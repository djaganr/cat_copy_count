// compile : kotlinc filename.kt
// execute : kotlin filenameKt arguments
import java.io.File
import java.io.InputStream
import java.nio.charset.Charset

fun main(arguments: Array<String>){

    if (arguments.size == 1){
        val fileName = arguments[0]
        File(fileName).useLines {lines->lines.forEach {println(it)}} 
    }

    if (arguments.size == 2 && arguments[1] != "-c"){
        val fileInput = arguments[0]
        val fileOutput = arguments[1]
        val myList = mutableListOf<String>()
        File(fileInput).useLines {lines->lines.forEach { myList.add(it)}}
        File(fileOutput).printWriter().use {out-> for(item in myList) {
            out.println(item)
        }} 

    }
    
    if (arguments.size == 2 && arguments[1]=="-c"){
        // create hashmap
        var hashMap: HashMap<String, Int> = HashMap<String, Int>()
        val builder = StringBuilder()
        val fileCount = arguments[0]
        File(fileCount).useLines {lines->lines.forEach { builder.append(it).append(" ")}}
        var words = builder.split("\\s+".toRegex())
        words = words.dropLast(1)
        for (c in words) {
            if (hashMap.containsKey(c)) {
                hashMap[c] = hashMap.getValue(c) + 1
            } else {
                hashMap[c] = 1
            }
        } 
        
        hashMap.forEach {(key, value) -> println("$key $value")}
        println("===========================")
        println("total count: ${words.size}")

        
    }

}