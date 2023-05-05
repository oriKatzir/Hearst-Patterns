# Discover Hypernyms using Hearst Patterns

This project is an OOP Java programming assignment, that i was given on the 2nd semester of my 1st year at BIU, involves regular expressions and hypernym relations. The goal of the assignment is to create a database of hypernym relations and discover hypernym relationships using Hearst patterns.

A hypernym relationship is a semantic relationship between two noun phrases, where one is a more general term (hypernym) and the other is a more specific term (hyponym). In this assignment, a well-established approach is used to construct a database of hypernym relations using Hearst patterns, and regular expressions are used to find and aggregate hypernym relations from a corpus.

Additional Information:

The assignment instructions state that finding NPs (noun phrases) in a text is a problem on its own, but this task has been automatically annotated for the students. The NPs are already marked with the <np> tag in the format shown below:

&quot;... &lt;np&gt;semitic languages&lt;/np> such as &lt;np>Hebrew&lt;/np> or &lt;np>Arabic&lt;/np> 
are composed of &lt;np>consonants&lt;/np> and &lt;np>voyels&lt;/np>.&quot;

This concession allows the students to focus on the main goal of the assignment, which is to create a database of hypernym relations and discover hypernym relationships using Hearst patterns, without worrying about NLP tasks such as NP recognition.

## Project Structure

The project has two parts: constructing a database of hypernym relations and discovering hypernym relations. 

### Part 1: Constructing a database of hypernym relations

This part involves creating a class that receives two arguments: the path to the corpus directory, and the path to the output file. The program reads all the files in the directory, finds and aggregates hypernym relations that match the Hearst patterns using regular expressions, and saves them in a txt file.

### Part 2: Discovering hypernym relations

In this part, several patterns are implemented to discover hypernym relationships, including those involving the words such as, as, including, and especially. 

## Getting Started

### Prerequisites

- Java 8 or higher

### Running the program

1. Clone the repository to your local machine
2. Open the project in your preferred IDE
3. Build and run the project
4. In the console, provide the path to the corpus directory and the lemma to search in the database as command-line arguments.

Example:

```
java DiscoverHypernym <path-to-corpus-directory> <lemma>
```

## Authors

- [Ori Katzir](https://github.com/orikatzir)

## Acknowledgments

This project was inspired by the work of [Martínez, M. P. (2014)](https://www.sciencedirect.com/science/article/abs/pii/S016764231300163X) on the automatic construction of a hypernym database.
