name := "zoo"
      
lazy val zoo = (project in file(".")).enablePlugins(PlayScala)
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % "0.8.0",
  "io.circe" %% "circe-generic" % "0.8.0",
  "io.circe" %% "circe-parser" % "0.8.0",
  ws)



      