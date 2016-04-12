(ns squaredfunction.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[squaredfunction started successfully]=-"))
   :middleware identity})
