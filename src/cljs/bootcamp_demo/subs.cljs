(ns bootcamp-demo.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::the-number
 (fn [db]
   (:the-number db)))


 (re-frame/reg-sub
  ::doubled-number
  (fn [db]
    (* 2 (:the-number db))))
