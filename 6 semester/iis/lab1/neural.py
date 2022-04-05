import numpy as np
from random import randint, random


class Neural:
    def __init__(self,
                 inp_data):
        self.input_data = inp_data  # входные данные
        self.weight = [randint(-10, 10), randint(-10, 10)]  # веса

    def calculate(self):
        summary = 0
        for i in range(self.input_data.__len__()):
            summary += self.input_data[i] * self.weight[i]
        return round(self._sig(summary))

    def calc_weight(self):
        self.weight[0] -= round(random(), 2) * (randint(-1, 1))
        self.weight[1] -= round(random(), 2) * (randint(-1, 1))

    @staticmethod
    def _sig(x):
        return 1 / (1 + np.exp(-x))
