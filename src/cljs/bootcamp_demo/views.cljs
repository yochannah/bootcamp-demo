(ns bootcamp-demo.views
  (:require
   [re-frame.core :as re-frame :refer [dispatch]]
   [bootcamp-demo.subs :as subs]
   [bootcamp-demo.events :as events]
   ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:header.status-bar]
    [:div
     [:h1 "Hello from " @name]

     [:form {:on-submit (fn [e]
                          (.preventDefault e)
                         (.log js/console "%ce" "background:DEEPSKYBLUE; border-radius:2px;" (clj->js (.-target e)))
                 (dispatch [::events/update-name ])
                         )}
      [:label "Type a new name here:"
        [:input {:type "text"}]]
      [:button {:type "submit"} "Update the name"]]
     ]))
