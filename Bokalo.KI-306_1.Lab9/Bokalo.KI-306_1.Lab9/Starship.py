class Starship:
    def __init__(self, name="void", c_name="Noname"):
        self.fuel = 100
        self.s_name = name
        self.s_health = 100
        self.staff = 10
        self.captain = Captain(c_name)
        self.is_fighting = False
        self.fout = None

    def closer(self):
        if self.fout is not None:
            self.fout.close()
            self.captain.close()

    def call_captain(self):
        self.captain.Captain_stats()

    def move(self):
        if self.fuel > 10:
            self.fuel -= 10
        else:
            print("Can't move!!!")

    def damage(self):
        if self.s_health > 0 and self.staff > 0:
            self.s_health -= 10
            self.staff -= 1
        elif self.s_health == 0:
            print("Starship is critically damaged!!!")

    def repair(self):
        if self.s_health < 100:
            self.staff += 5
            self.s_health += 10
            coins = self.captain.getCoins()
            coins -= 50
            self.captain.setCoins(coins)
        else:
            print("Repaired")

    def fight(self):
        self.is_fighting = True
        self.damage()
        coins = self.captain.getCoins()
        self.captain.setCoins(coins + 25)

    def retreat(self):
        self.is_fighting = False

    def stats(self):
        print("Stats:")
        print("Name:", self.s_name)
        print("Fuel:", self.fuel)
        print("Health:", self.s_health)
        print("Staff:", self.staff)
        print("Fighting:", self.is_fighting)

    def refuel(self):
        self.fuel = 100
        coins = self.captain.getCoins()
        self.captain.setCoins(coins - 25)

    def clearShip_logs(self):
        try:
            with open("Starship_log.txt", "w") as clearWriter:
                clearWriter.close()
        except FileNotFoundError:
            print("Error: File 'Starship_log.txt' cannot be cleared.")


class Captain:
    def __init__(self, name="Noname"):
        self.name = name
        self.coins = 100
        self.health = 100
        self.id = 0
        self.fout = None

    def getCoins(self):
        return self.coins

    def setCoins(self, coins):
        self.coins = coins

    def Captain_stats_file(self):
        print("New Captain created:")
        print("ID:", self.id)
        print("Name:", self.name)
        print("Coins:", self.coins)
        print("Health:", self.health)

    def Captain_stats(self):
        print("Your captain has:")
        print("Name:", self.name)
        print("Coins:", self.coins)
        print("Health:", self.health)

    def close(self):
        if self.fout is not None:
            self.fout.close()

    def clearCaptain_logs(self):
        try:
            with open("Captain_log.txt", "w") as clearWriter:
                clearWriter.close()
        except FileNotFoundError:
            print("Error: File 'Captain_log.txt' cannot be cleared.")

