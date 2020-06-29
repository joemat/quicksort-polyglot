load("nashorn:mozilla_compat.js");
importPackage(Packages.de.joemat.learning.quicksort_polyglot.api)
importPackage(Packages.java.util)

var sortAlgo = {
    apply: function (unsorted, resultHandler) {
       unsorted.sort(Comparator.naturalOrder())
       resultHandler.accept(unsorted);
       return unsorted;
    }
}

var quicksort = new Sorter(sortAlgo);
