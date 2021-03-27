scalaVersion := "2.13.5"

name := "parenthesis-checker"
organization := "com.virtuslab"
version := "0.1.0"

libraryDependencies ++= List(
  "org.scalameta" %% "scalameta" % "4.4.10",
  "org.scalameta" %% "munit" % "0.7.21" % Test,
  "com.lihaoyi" %% "pprint" % "0.6.0"
)

logo := Welcome.logo
usefulTasks := Welcome.tasks