
from Starship import Starship

class Multi_Starship(Starship):
    def __init__(self, name="void", c_name="Noname"):
        super().__init__(name, c_name)
        self.Life_points = 5

    def Star_jump(self):
        for _ in range(5):
            self.move()

    def repair(self):
        if self.s_health == 0:
            self.Life_points = self.Life_points - 1 if self.Life_points > 0 else self.Life_points
            super().repair()
        elif self.Life_points == 0:
            print("Out of life points!!! Get more")
        elif 0 < self.s_health < 100:
            super().repair()

    def stats(self):
        super().stats()
        print("Life Points:", self.Life_points)
