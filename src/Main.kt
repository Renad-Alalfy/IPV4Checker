fun check(name: String, result: Boolean, correct: Boolean) {
    if (result == correct) {
        println("success - $name")
    } else {
        println("failed - $name")
    }
}
fun isValidIPv4(ip: String): Boolean {
    val segments = ip.split('.')

    if (segments.size != 4) return false

    for (segment in segments) {
        if (segment != "0" && segment.startsWith('0')) return false
        for (char in segment) {
            if (!char.isDigit()) return false
        }
        if (segment.toInt() !in 0..255) return false
    }
    return true
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    check(
        name = "should return true when valid ipv4 address",
        isValidIPv4("198.168.1.1"),
        correct = true
    )

    check(
        name = "should return false when IPv4 address with more than 3 dots",
        isValidIPv4("192.168.1.1.1"),
        correct = false
    )

    check(
        name = "should return false when IPv4 address with less than 3 dots",
        isValidIPv4("192.168.1"),
        correct = false
    )

    check(
        name = "should return false when IPv4 address with non-numeric segment",
        isValidIPv4("192.168.1.a"),
        correct = false
    )

    check(
        name = "should return false when IPv4 address with invalid number (greater than 255)",
        isValidIPv4("192.168.1.300"),
        correct = false
    )

    check(
        name = "should return false when IPv4 address with leading zeros in a segment",
        isValidIPv4("192.168.01.1"),
        correct = false
    )

    check(
        name = "should return false when IPv4 address with negative number",
        isValidIPv4("192.168.-1.1"),
        correct = false
    )

    check(
        name = "should return false when IPv4 address with extra spaces",
        isValidIPv4("192.168.1.1 "),
        correct = false
    )


}