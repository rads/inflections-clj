(ns test.inflections
  (:use clojure.test inflections))

(deftest test-dasherize
  (are [word expected]
       (= (dasherize word) expected)
       "puni_puni" "puni-puni"
       "street"  "street"
       "street_address" "street-address"
       "person_street_address" "person-street-address"))

(deftest test-irregular?
  (is (every? irregular? (keys @*irregular-words*)))
  (is (every? irregular? (vals @*irregular-words*)))
  (are [word]
       (is (= (irregular? word) true))
       "person" "people" "man" "men" "child" "children"))

(deftest test-uncountable?
  (is (every? uncountable? (keys @*uncountable-words*)))
  (are [word]
       (is (= (uncountable? word) true))
       "air" "alcohol" "art" "blood" "butter" "cheese"))

(deftest test-underscore
  (are [word expected]
       (= (underscore word) expected)
       "puni-puni" "puni_puni"
       "puni puni" "puni_puni"))

(deftest test-ordinalize
  (are [number expected]
       (= (ordinalize number) expected)
       "0" "0th"
       "1" "1st"
       "2" "2nd"
       "3" "3rd"
       "4" "4th"
       "5" "5th"
       "6" "6th"
       "7" "7th"
       "8" "8th"
       "9" "9th"
       "10" "10th"
       "11" "11th"
       "12" "12th"
       "13" "13th"
       "14" "14th"
       "20" "20th"
       "21" "21st"
       "22" "22nd"
       "23" "23rd"
       "24" "24th"
       "100" "100th"
       "101" "101st"
       "102" "102nd"
       "103" "103rd"
       "104" "104th"
       "110" "110th"
       "111" "111th"
       "112" "112th"
       "113" "113th"
       "1000" "1000th"
       "1001" "1001st"))
