# from : https://github.com/nlintz/TensorFlow-Tutorials/blob/master/00_multiply.py

import tensorflow as tf

## Placeholders 
# TensorFlow provides a placeholder operation that must be fed with data on execution.
# Value must be fed using the feed_dict optional argument to Session.run(), Tensor.eval(), or Operation.run().

a = tf.placeholder("float") # Create a symbolic variable 'a'
b = tf.placeholder("float") # Create a symbolic variable 'b'

y = tf.multiply(a, b) # multiply the symbolic variables

with tf.Session() as sess: # create a session to evaluate the symbolic expressions
    print("%f should equal 2.0" % sess.run(y, feed_dict={a: 1, b: 2})) # eval expressions with parameters for a and b
    print("%f should equal 9.0" % sess.run(y, feed_dict={a: 3, b: 3}))