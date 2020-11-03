package luna

class Luna {
    static boolean luna(code) {
        def reduced_code = code.findAll({ it.isInteger() }).collect({ it.toString().toInteger() })
        def positive = reduced_code[(0..15).step(2)].collect({(it * 2 > 9) ? (it * 2 - 9) : (it * 2) })
        def negative = reduced_code[(1..15).step(2)]
        return (positive.sum() + negative.sum()) % 10 == 0
    }

    static void read_cards(List data){
        new File('inputs/cards.txt').eachLine {
            data.add(it)
        }
    }

    static void main(String[] args) {
        def data = []
        read_cards(data)

        for (def item : data){
            def check = luna(item)
            if (check)
                println "$item is correct"
            else
                println "$item is incorrect"
        }
    }
}
