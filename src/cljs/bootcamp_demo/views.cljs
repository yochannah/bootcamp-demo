(ns bootcamp-demo.views
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]
   [bootcamp-demo.subs :as subs]
   [bootcamp-demo.events :as events]))

(defn handle-typing
  "Handles typing in the text field.
   `event` is the default event passed to any javascript event listener.
   `(.-value (.-target event))` is the equivalent of event.target.value in js"
  [event]
  (let [input-value (.-value (.-target event))]
    (dispatch [::events/update-number input-value])))

(defn number-output
  "visual reagent componet to output the results of any typing"
  []
  (let [num (re-frame/subscribe [::subs/the-number])
        doublenum (re-frame/subscribe [::subs/doubled-number])]
    [:div
     [:h2 "Results"]
     [:div "Your number: " @num]
     [:div "Double number: " @doublenum]]))

(defn main-panel
  "The main entry point for this application. Renders output to screen"
  ;; Note: the entry point in Clojure will always be at the bottom of the file
  ;; because it reads from top down - so if you moved handle-typing or number-output
  ;; down below this function, you'd get a compile error. You can't call functions
  ;; that don't exist yet.
  []
    [:div
     [:h1 "Barebones demo!"]
     [:form
      [:label "I'll double any number: "
       [:input {:type "text"
                ;; we've given the input a function name to run anytime the
                ;; value of the input changes. See handle-typing on line 7
                :on-change handle-typing}]]]
     ;; here we're embedding a reagent component inside another component.
     ;; note that we use square brackets [] to embed a reagent component,
     ;; unlike other functions where we'd call them via round brackets ()
     [number-output]])
