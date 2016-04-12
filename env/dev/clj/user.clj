(ns user
  (:require [mount.core :as mount]
            squaredfunction.core))

(defn start []
  (mount/start-without #'squaredfunction.core/repl-server))

(defn stop []
  (mount/stop-except #'squaredfunction.core/repl-server))

(defn restart []
  (stop)
  (start))


