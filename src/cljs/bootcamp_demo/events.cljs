(ns bootcamp-demo.events
  (:require
   [re-frame.core :as re-frame]
   [bootcamp-demo.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
 ::update-number
 (fn [db [_ the-number]]
   (assoc db :the-number the-number)
   ))
