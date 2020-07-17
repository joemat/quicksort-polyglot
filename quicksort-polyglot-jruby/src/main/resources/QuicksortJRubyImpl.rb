require "java"
java_import "de.joemat.learning.quicksort_polyglot.api.Sorter"
java_import "java.util.Arrays"
java_import "java.lang.Integer"

class QuicksortJRuby include Sorter

    # taken from https://www.rubyguides.com/2017/07/ruby-sort/
    def quicksort(unsorted)
      return [] if unsorted.empty?
      groups = unsorted.group_by { |n| n <=> unsorted.first }
      less_than    = groups[-1] || []
      first        = groups[0]  || []
      greater_than = groups[1]  || []
      quicksort(less_than) + first + quicksort(greater_than)
    end

    def asJavaIntegerList(list)
        Arrays.asList(list.to_java(Integer))
    end

    def apply(unsorted, callback)
        sorted = quicksort(unsorted)
        callback.accept(asJavaIntegerList(sorted))
        asJavaIntegerList(sorted)
    end
end

quicksort = QuicksortJRuby.new