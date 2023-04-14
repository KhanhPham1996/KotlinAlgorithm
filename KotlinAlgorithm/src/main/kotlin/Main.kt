fun main(args: Array<String>) {
    val stack = stackOf(1.0, 2.0, 3.0, 4.0)
    print(stack)
    println("Popped: ${stack.pop()}")
    val  a : List<String> = listOf("")
    a.toMutableList()
}
class StackImpl<T : Any> : Stack<T> {
    private val storage = arrayListOf<T>()
    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (storage.size == 0) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }

    override fun peek(): T? {
      return  storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size


    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }

    companion object {
        fun <T : Any> create(items: Iterable<T>): Stack<T> {
            val stack = StackImpl<T>()
            for (item in items) {
                stack.push(item)
            }
            return stack
        }
    }
}
fun <T : Any> stackOf(vararg elements: T): Stack<T> {
    return StackImpl.create(elements.asList())
}


interface Stack<T : Any> {
    fun push(element: T)
    fun pop(): T?
    fun peek(): T?

    val count: Int
        get

    val isEmpty: Boolean
        get() = count == 0
}