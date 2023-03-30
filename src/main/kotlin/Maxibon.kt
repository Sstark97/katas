class Maxibon {
    private var maxibons = 10;

    fun getMaxibons (): Int {
        return this.maxibons
    }

    fun take(developer: String) {
        if(developer === "Pedro") {
            this.maxibons -= 3
        }
    }
}