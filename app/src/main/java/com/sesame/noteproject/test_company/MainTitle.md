#### MainTitle

> 果然只看不做是不行的，遇到了好多问题。

遇到的问题有:

1. [自定义View] MainTitle没有显示出来，在Activity中打断点发现mMainTitle.getToolBar()为null，打断点，自定义的MainTitle中的断点也没有走。最后发现是构造方法中前两个应该用this()而不是super()。
 
2. ToolBar有左边距。

3. ……

> 做完才觉得并没有那么难，就是一个自定义title控件，然后放到原先ActionBar的位置上。
