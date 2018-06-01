(defproject bootcamp-demo "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [reagent "0.7.0"]
                 [re-frame "0.10.5"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-less "1.7.5"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :less {:source-paths ["less"]
         :target-path  "resources/public/css"}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.10"]
                   [re-frisk "0.5.3"]]

    :plugins      [[lein-figwheel "0.5.16"]]}
   :prod { }}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "bootcamp-demo.core/mount-root"}
     :compiler     {:main                 bootcamp-demo.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true
                    :preloads             [devtools.preload
                                           re-frisk.preload]
                    :external-config      {:devtools/config {:features-to-install :all}}
                    }}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            bootcamp-demo.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}


    ]}

  )
