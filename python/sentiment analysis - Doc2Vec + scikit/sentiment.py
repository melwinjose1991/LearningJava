import sys
import collections
import sklearn.naive_bayes
import sklearn.linear_model
import nltk
import random
random.seed(0)
from gensim.models.doc2vec import LabeledSentence, Doc2Vec
#nltk.download("stopwords")          # Download the stop words from nltk

from collections import Counter

# User input path to the train-pos.txt, train-neg.txt, test-pos.txt, and test-neg.txt datasets
if len(sys.argv) != 3:
    print "python sentiment.py <path_to_data> <0|1>"
    print "0 = NLP, 1 = Doc2Vec"
    exit(1)
path_to_data = sys.argv[1]
method = int(sys.argv[2])



def main():
    train_pos, train_neg, test_pos, test_neg = load_data(path_to_data)
    # each of them is a list containing a list words for each tweet/review 

    if method == 0:
        train_pos_vec, train_neg_vec, test_pos_vec, test_neg_vec = feature_vecs_NLP(train_pos, train_neg, test_pos, test_neg)
        nb_model, lr_model = build_models_NLP(train_pos_vec, train_neg_vec)
    if method == 1:
        train_pos_vec, train_neg_vec, test_pos_vec, test_neg_vec = feature_vecs_DOC(train_pos, train_neg, test_pos, test_neg)
        nb_model, lr_model = build_models_DOC(train_pos_vec, train_neg_vec)
    
    print "Naive Bayes"
    print "-----------"
    evaluate_model(nb_model, test_pos_vec, test_neg_vec, True)
    print ""
    print "Logistic Regression"
    print "-------------------"
    evaluate_model(lr_model, test_pos_vec, test_neg_vec, True)


def load_data(path_to_dir):
    """
    Loads the train and test set into four different lists.
    """
    train_pos = []
    train_neg = []
    test_pos = []
    test_neg = []
    with open(path_to_dir+"train-pos.txt", "r") as f:
        for i,line in enumerate(f):
            words = [w.lower() for w in line.strip().split() if len(w)>=3]
            train_pos.append(words)
    with open(path_to_dir+"train-neg.txt", "r") as f:
        for line in f:
            words = [w.lower() for w in line.strip().split() if len(w)>=3]
            train_neg.append(words)
    with open(path_to_dir+"test-pos.txt", "r") as f:
        for line in f:
            words = [w.lower() for w in line.strip().split() if len(w)>=3]
            test_pos.append(words)
    with open(path_to_dir+"test-neg.txt", "r") as f:
        for line in f:
            words = [w.lower() for w in line.strip().split() if len(w)>=3]
            test_neg.append(words)

    print train_pos[0]
    return train_pos, train_neg, test_pos, test_neg



stopwords = set(nltk.corpus.stopwords.words('english'))

def removeStopWords(posts, flatten=True):
	for i in range(len(posts)):
		tmp = []
		for word in posts[i]:
			if word not in stopwords:
				tmp.append(word)
		posts[i] = tmp
	
	#return list_of_lines 
	if flatten:
		flatened_list = [word for post in posts for word in post]
		return flatened_list
	else:
		return posts

def getVector(posts, features):
	vectors = []
	for post in posts:
		vector = []
		for word in features:
			if word in post:
				vector.append(1)
			else:
				vector.append(0)
		vectors.append(vector)
	return vectors

def feature_vecs_NLP(train_pos, train_neg, test_pos, test_neg):
    """
    Returns the feature vectors for all text in the train and test datasets.
    """
    # English stopwords from nltk
    # stopwords = set(nltk.corpus.stopwords.words('english'))
    #    above variable has been made global
    # stopwords : words which are neutral in sentiments 
 
    # Determine a list of words that will be used as features. 
    # This list should have the following properties:
    #   (1) Contains no stop words
    #   (2) Is in at least 1% of the positive texts or 1% of the negative texts
    #   (3) Is in at least twice as many postive texts as negative texts, or vice-versa.
    # YOUR CODE HERE
    nonstop_train_pos = removeStopWords(train_pos)
    nonstop_train_neg = removeStopWords(train_neg)
    nonstop_test_pos = removeStopWords(test_pos)
    nonstop_test_neg = removeStopWords(test_neg)	

    train_pos_len = len(train_pos)
    train_neg_len = len(train_neg)

    nonstop_train_pos_count = Counter(nonstop_train_pos)
    nonstop_train_neg_count = Counter(nonstop_train_neg)

    one_percent_nonstop_train_pos = [word for word in nonstop_train_pos if nonstop_train_pos_count[word] >= (0.01*train_pos_len)]
    one_percent_nonstop_train_neg = [word for word in nonstop_train_neg if nonstop_train_neg_count[word] >= (0.01*train_neg_len)]

    one_percent_nonstop_train_pos_count = Counter(one_percent_nonstop_train_pos)
    one_percent_nonstop_train_neg_count = Counter(one_percent_nonstop_train_neg)

    pos_final = [word for word in one_percent_nonstop_train_pos if one_percent_nonstop_train_pos_count[word] >= (2*one_percent_nonstop_train_neg_count.get(word,0))]
    neg_final = [word for word in one_percent_nonstop_train_neg if one_percent_nonstop_train_neg_count[word] >= (2*one_percent_nonstop_train_pos_count.get(word,0))]

    features = set(pos_final + neg_final)
    print "Features:",features 
    # Using the above words as features, construct binary vectors for each text in the training and test set.
    # These should be python lists containing 0 and 1 integers.
    # YOUR CODE HERE
    train_pos_vec = getVector(train_pos, features)
    train_neg_vec = getVector(train_neg, features)
    test_pos_vec = getVector(test_pos, features)
    test_neg_vec = getVector(test_neg, features)

    # Return the four feature vectors
    print "Train_Pos_Vec[0]",train_pos_vec[0]
    return train_pos_vec, train_neg_vec, test_pos_vec, test_neg_vec



def getLabeledSentence(label_prefix, sentences):
	labeledSentences = []
	for i,sentence in enumerate(sentences):
		label = label_prefix+str(i)
		labeledSentences.append(LabeledSentence(sentence, [label]))
	return labeledSentences

def getVecs(model, label_prefix, sentences):
	vectors = []
	for i in range(len(sentences)):
		label=label_prefix+str(i)
		vectors.append(model.docvecs[label])
	return vectors
	
def feature_vecs_DOC(train_pos, train_neg, test_pos, test_neg):
    """
    Returns the feature vectors for all text in the train and test datasets.
    """
    # Doc2Vec requires LabeledSentence objects as input.
    # Turn the datasets from lists of words to lists of LabeledSentence objects.
    # YOUR CODE HERE
    train_pos = removeStopWords(train_pos, False)
    train_neg = removeStopWords(train_neg, False)
    test_pos = removeStopWords(test_pos, False)
    test_neg = removeStopWords(test_neg, False)

    labeled_train_pos = getLabeledSentence('TRAIN_POS_', train_pos)
    labeled_train_neg = getLabeledSentence('TRAIN_NEG_', train_neg)
    labeled_test_pos = getLabeledSentence('TEST_POS_', test_pos)
    labeled_test_neg = getLabeledSentence('TEST_NEG_', test_neg)
    print labeled_train_pos[0]

    # Initialize model
    model = Doc2Vec(min_count=1, window=10, size=100, sample=1e-4, negative=5, workers=4)
    sentences = labeled_train_pos + labeled_train_neg + labeled_test_pos + labeled_test_neg
    model.build_vocab(sentences)

    # Train the model
    # This may take a bit to run 
    for i in range(5):
        print "Training iteration %d" % (i)
        random.shuffle(sentences)
        model.train(sentences)

    # Use the docvecs function to extract the feature vectors for the training and test data
    # YOUR CODE HERE
    train_pos_vec = getVecs(model, 'TRAIN_POS_', train_pos)
    train_neg_vec = getVecs(model, 'TRAIN_NEG_', train_neg)
    test_pos_vec = getVecs(model, 'TEST_POS_', test_pos)
    test_neg_vec = getVecs(model, 'TEST_NEG_', test_neg) 
    print train_pos_vec[0]   

    # Return the four feature vectors
    return train_pos_vec, train_neg_vec, test_pos_vec, test_neg_vec



def build_models_NLP(train_pos_vec, train_neg_vec):
    """
    Returns a BernoulliNB and LosticRegression Model that are fit to the training data.
    """
    Y = ["pos"]*len(train_pos_vec) + ["neg"]*len(train_neg_vec)

    # Use sklearn's BernoulliNB and LogisticRegression functions to fit two models to the training data.
    # For BernoulliNB, use alpha=1.0 and binarize=None
    # For LogisticRegression, pass no parameters
    # YOUR CODE HERE
    X = train_pos_vec + train_neg_vec

    nb_model = sklearn.naive_bayes.BernoulliNB(alpha=1.0, binarize=None)
    nb_model.fit(X, Y)

    lr_model = sklearn.linear_model.LogisticRegression()
    lr_model.fit(X, Y) 
    return nb_model, lr_model



def build_models_DOC(train_pos_vec, train_neg_vec):
    """
    Returns a GaussianNB and LosticRegression Model that are fit to the training data.
    """
    Y = ["pos"]*len(train_pos_vec) + ["neg"]*len(train_neg_vec)

    # Use sklearn's GaussianNB and LogisticRegression functions to fit two models to the training data.
    # For LogisticRegression, pass no parameters
    # YOUR CODE HERE
    X = train_pos_vec + train_neg_vec

    nb_model = sklearn.naive_bayes.GaussianNB()
    nb_model.fit(X, Y)

    lr_model = sklearn.linear_model.LogisticRegression()
    lr_model.fit(X, Y) 
    
    return nb_model, lr_model



def evaluate_model(model, test_pos_vec, test_neg_vec, print_confusion=False):
    	"""
    	Prints the confusion matrix and accuracy of the model.
    	"""
    	# Use the predict function and calculate the true/false positives and true/false negative.
    	# YOUR CODE HERE
	predicted_pos = model.predict(test_pos_vec)
        predicted_neg = model.predict(test_neg_vec)
        tp = 0
        fn = 0
        tn = 0
        fp = 0
        for sentiment in predicted_pos:
                if sentiment == 'pos':
                        tp = tp + 1
                else:
                        fn = fn + 1
        for sentiment in predicted_neg:
                if sentiment == 'neg':
                        tn = tn + 1
                else:
                        fp = fp + 1
        accuracy = (float)(tp + tn)/(tp + fn + tn + fp)
        if print_confusion:
                  print "predicted:\tpos\tneg"
                  print "actual:"
                  print "pos\t\t%d\t%d" % (tp, fn)
                  print "neg\t\t%d\t%d" % (fp, tn)
        print "accuracy: %f" % (accuracy)    


if __name__ == "__main__":
    main()
