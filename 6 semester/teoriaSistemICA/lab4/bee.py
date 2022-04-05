import random


class abstract_bee:
    def __init__(self):
        self.position = None
        self.minval = None
        self.maxval = None

        self.fitness = 0.0

    def calcfitness(self):
        pass

    def __lt__(self, otherbee):
        return self.fitness < otherbee.fitness

    def otherpatch(self, bee_list, range_list):
        if len(bee_list) == 0:
            return True

        for curr_bee in bee_list:
            position = curr_bee.getposition()

            for n in range(len(self.position)):
                if abs(self.position[n] - position[n]) > range_list[n]:
                    return True

        return False

    def getposition(self):
        return [val for val in self.position]

    def goto(self, otherpos, range_list):
        self.position = [otherpos[n] + random.uniform(-range_list[n], range_list[n]) \
                         for n in range(len(otherpos))]

        self.checkposition()

        self.calcfitness()

    def gotorandom(self):
        self.position = [random.uniform(self.minval[n], self.maxval[n]) for n in range(len(self.position))]
        self.checkposition()
        self.calcfitness()

    def checkposition(self):
        for n in range(len(self.position)):
            if self.position[n] < self.minval[n]:
                self.position[n] = self.minval[n]

            elif self.position[n] > self.maxval[n]:
                self.position[n] = self.maxval[n]


class sphere_bee(abstract_bee):
    count = 2

    @staticmethod
    def getstartrange():
        return [150.0] * sphere_bee.count

    @staticmethod
    def getrangekoeff():
        return [0.98] * sphere_bee.count

    def __init__(self):
        abstract_bee.__init__(self)

        self.minval = [-150.0] * sphere_bee.count
        self.maxval = [150.0] * sphere_bee.count

        self.position = [random.uniform(self.minval[n], self.maxval[n]) for n in range(sphere_bee.count)]
        self.calcfitness()

    def calcfitness(self):
        self.fitness = 0.0
        for val in self.position:
            self.fitness -= val * val
