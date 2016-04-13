(ns squaredfunction.routes.home
  (:require [squaredfunction.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page []
  (layout/render "about.html"))

(def resource-path "/tmp/squaredfunction/")

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (POST "/upload"
        ;; 'filename' should be a crypto-random based name
        {{{tempfile :tempfile filename :filename} :file} :params :as params}
        (io/copy tempfile (io/file resource-path filename))
        "Success"))
