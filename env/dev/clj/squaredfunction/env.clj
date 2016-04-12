(ns squaredfunction.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [squaredfunction.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[squaredfunction started successfully using the development profile]=-"))
   :middleware wrap-dev})
