# classification4j

A simple machine learning classification api for java.

## What is classification?

Put simply, classification is a means of determining what something is based on what we already know.

### Glossary of Terms

* Classifier - A description of what something is.
* Feature - An attribute of the entity to be described.
* Instance - A classified set of features.
* Training data - Provides a baseline for the entities being classified.  More training data means more accurate results.

### Example

Consider the following set of training data based on people:

| Name | Eye Colour | Hair Colour | Height |
| ---- | ---------- | ----------- | ------ |
| Jim  | Blue       | Brown       | 6"2'   |
| Jane | Green      | Black       | 5"7'   |
| John | Brown      | Blonde      | 5"9'   |

And the unclassified instance:

| Name | Eye Colour | Hair Colour | Height |
| ---- | ---------- | ----------- | ------ |
| N/A  | Blue       | N/A         | N/A    |

We could assert that the unclassified instance is Jim based on the data we have available to us.

## [k Nearest Neighbours (k-NN)](https://en.wikipedia.org/wiki/K-nearest_neighbors_algorithm)

> k-NN is a type of instance-based learning, or lazy learning, where the function is only approximated locally and all computation is deferred until classification. The k-NN algorithm is among the simplest of all machine learning algorithms.

> Both for classification and regression, it can be useful to assign weight to the contributions of the neighbors, so that the nearer neighbors contribute more to the average than the more distant ones. For example, a common weighting scheme consists in giving each neighbor a weight of 1/d, where d is the distance to the neighbor.

> The neighbors are taken from a set of objects for which the class (for k-NN classification) or the object property value (for k-NN regression) is known. This can be thought of as the training set for the algorithm, though no explicit training step is required.

## [Naive Bayes](https://en.wikipedia.org/wiki/Naive_Bayes_classifier)

> Naive Bayes is a simple technique for constructing classifiers: models that assign class labels to problem instances, represented as vectors of feature values, where the class labels are drawn from some finite set. It is not a single algorithm for training such classifiers, but a family of algorithms based on a common principle: all naive Bayes classifiers assume that the value of a particular feature is independent of the value of any other feature, given the class variable. For example, a fruit may be considered to be an apple if it is red, round, and about 10 cm in diameter. A naive Bayes classifier considers each of these features to contribute independently to the probability that this fruit is an apple, regardless of any possible correlations between the color, roundness, and diameter features.

* Note: Content shamelessly stolen from wikipedia. Links provided.
