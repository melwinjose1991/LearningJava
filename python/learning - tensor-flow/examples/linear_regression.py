# from : https://github.com/nlintz/TensorFlow-Tutorials/blob/master/01_linear_regression.py

import tensorflow as tf
import numpy as np

'''
linspace(): Returns 101 evenly spaced samples, calculated over the interval [-1, 1].
'''
trX = np.linspace(-1, 1, 101)
print(trX)

'''
randn(): Return a sample (or samples) from the 'standard normal' distribution
    mean=0 AND std.dev=1

create a y value which is approximately linear but with some random noise
    0.33 = std.dev
    2*trX = mean
    trX.shape = n = 101
'''
trY = 2 * trX + np.random.randn(*trX.shape) * 0.33 


X = tf.placeholder("float") # create symbolic variables
Y = tf.placeholder("float")


''' 
tf.Vairable(<init-value>, name=<name>, trainable=True)
    When you train a model, you use variables to hold and update parameters. Variables 
    are in-memory buffers containing tensors. They must be explicitly initialized and 
    can be saved to disk during and after training. You can later restore saved values 
    to exercise or analyze the model.
'''
# create a shared variable for the weight matrix
w = tf.Variable(0.0, name="weights") 

'''
Variable initializers must be run explicitly before other ops in your model 
can be run. The easiest way to do that is to add an op that runs all the 
variable initializers, and run that op before using the model.
'''
init_op = tf.global_variables_initializer()

# use square error for cost_function function
cost_function = tf.square(Y - tf.multiply(X, w)) 

'''
The Optimizer base class provides methods to compute gradients for a loss 
and apply gradients to variables. A collection of subclasses implement 
classic optimization algorithms such as GradientDescent and Adagrad.
You never instantiate the Optimizer class itself, but instead instantiate 
one of the subclasses.

minimize(loss, var_list=None)
    Calling minimize() takes care of both computing the gradients and applying 
    them to the variables. 
    
    - loss:  A Tensor containing the value to minimize.
    - var_list: Optional list of Variable objects to update to minimize loss. 
        Defaults to the list of variables collected in the graph under the key 
        GraphKeys.TRAINABLE_VARIABLES.
'''
train_op = tf.train.GradientDescentOptimizer(0.01).minimize(cost_function) 

# Launch the graph in a session
with tf.Session() as sess:
    # you need to initialize variables (in this case just variable W)
    sess.run(init_op)

    for i in range(25):
        for (x, y) in zip(trX, trY):
            sess.run(train_op, feed_dict={X: x, Y: y})
        print("W:",sess.run(w),"after i:",i)

    print(sess.run(w))
    
'''
Session.run(fetches, feed_dict=None, options=None, run_metadata=None)
    Runs operations and evaluates tensors in fetches.

    This method runs one "step" of TensorFlow computation, by running the necessary graph 
    fragment to execute every Operation and evaluate every Tensor in fetches, substituting 
    the values in feed_dict for the corresponding input values.
    
    The fetches argument may be a single graph element, or an arbitrarily nested list, 
    tuple, namedtuple, dict, or OrderedDict containing graph elements at its leaves. 
    A graph element can be one of the following types:
        - An tf.Operation: The corresponding fetched value will be None.
        - A tf.Tensor: The corresponding fetched value will be a numpy ndarray containing 
            the value of that tensor.
            
    feed_dict argument allows the caller to override the value of tensors in the graph
'''