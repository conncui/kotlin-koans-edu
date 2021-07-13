package func




fun main(){
    var infoBeanList = listOf(
            StudentBean("name1",1, listOf(ScoreBean("math",150), ScoreBean("eng",150))),
            StudentBean("name2",2, listOf(ScoreBean("math",149),ScoreBean("eng",149))),
            StudentBean("name2",3, listOf(ScoreBean("math",148),ScoreBean("eng",148)))
    )
    println(infoBeanList)
    println("start flatMap")

    var list = infoBeanList.flatMap { it.scoreBeanList }

    println("end flatMap")
    /**
    String str = "start flatMap";
        int j = 0;
        System.out.println(str);

        Object $this$flatMap$iv = (Iterable)infoBeanList;
        int $i$f$flatMap = 0;

        Object localObject1 = $this$flatMap$iv;
        Collection destination$iv$iv = (Collection)new ArrayList();
        Iterable $this$flatMapTo$iv$iv;
        int $i$f$flatMapTo = 0;
        for (Iterator localIterator = $this$flatMapTo$iv$iv.iterator(); localIterator.hasNext();) {
            element$iv$iv = localIterator.next();
            StudentBean it = (StudentBean)element$iv$iv;
            int $i$a$ - flatMap - FunFlatMapKt$main$map$1 = 0;
            Iterable list$iv$iv = (Iterable)it.getScoreBeanList();
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        List map = (List)destination$iv$iv;
        $this$flatMap$iv = "end flatMap";
        $i$f$flatMap = 0;
        System.out.println($this$flatMap$iv);
    */


    println("start flatMap 2")

    var nameMap = infoBeanList.flatMap { listOf(it.name)}

    println("nameMap"+nameMap)
    println("end flatMap 2")
    println(infoBeanList.flatMap { it.scoreBeanList })

}