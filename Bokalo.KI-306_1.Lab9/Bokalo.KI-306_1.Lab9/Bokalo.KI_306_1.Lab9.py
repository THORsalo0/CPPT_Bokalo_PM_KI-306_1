
from Starship import Starship
from Multi_Starship import Multi_Starship


def main():
    ms = Multi_Starship("Boss", "Soreman")

    ms.stats()

    print("\n")

    for i in range(10):
        ms.fight()

    print("\n")

    ms.stats()

    print("\n")

    ms.repair()

    print("\n")

    ms.call_captain()

    print("\n")

    ms.stats()

    print("\n")

    ms.call_captain()

    print("\n")

    ms.closer()

    print("\n")

if __name__ == "__main__":
    main()
