A checker that shows the user whether a
provided Scala code snippet contains the proper number of parenthesis: `(` and
`)`. You can find the main entrypoint in
`src/main/scala/com/virtuslab/Main.scala` together with the assignment details.
We also included a couple of example code snippets in the `code-samples`
directory.

We included some basic libraries in the project, but you can use any alternative
ones that you prefer. We also included a small coursier runnable jar, which will
require Java JDK to run. Using it you can install all the needed software such
as the sbt build tool, which is used in the project, using:

`./coursier install sbt`

sbt will allow you to run and test your code from commandline.

If you don't have java JDK on you system it can also be setup easily using
[coursier](https://get-coursier.io/docs/cli-setup)

Alternatively you can use recommended code editors such as:

- [Intellij](https://www.jetbrains.com/idea/)
- [Visual Studio Code](https://code.visualstudio.com/) with the
  [Metals](https://scalameta.org/metals/docs/editors/vscode.html) plugin.
