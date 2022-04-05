from abc import ABC, abstractmethod

from comtypes.safearray import numpy as np
from lab2.particle import Particle


class Swarm(ABC):
    def __init__(self,
                 swarm_size,
                 min_values,
                 max_values,
                 current_velocity_ratio,
                 local_velocity_ratio,
                 global_velocity_ratio):
        self._swarm_size = swarm_size

        assert len(min_values) == len(max_values)
        assert (local_velocity_ratio + global_velocity_ratio) > 4

        self.min_values = np.array(min_values[:])
        self.max_values = np.array(max_values[:])

        self.current_velocity_ratio = current_velocity_ratio
        self.local_velocity_ratio = local_velocity_ratio
        self.global_velocity_ratio = global_velocity_ratio

        self.global_best_final_func = None
        self.global_best_position = None

        self._swarm = self.__createSwarm()

        super().__init__()

    @property
    def dimension(self):
        return len(self.min_values)

    def __createSwarm(self):
        return [Particle(self) for _ in range(self._swarm_size)]

    def nextIteration(self):
        for particle in self._swarm:
            particle.nextIteration(self)

    @abstractmethod
    def _finalFunc(self, position):
        pass

    def _getPenalty(self, position, ratio):
        penalty1 = \
            sum([ratio * abs(coord - min_val) for coord, min_val in zip(position, self.min_values) if coord < min_val])

        penalty2 = \
            sum([ratio * abs(coord - max_val) for coord, max_val in zip(position, self.max_values) if coord > max_val])

        return penalty1 + penalty2

    def getFinalFunc(self, position):
        assert len(position) == len(self.min_values)

        final_func = self._finalFunc(position)

        if (self.global_best_final_func is None or
                final_func < self.global_best_final_func):
            self.global_best_final_func = final_func
            self.global_best_position = position[:]

        return final_func

    def __getitem__(self, item):
        return self._swarm[item]


class Schefell_Swarm(Swarm):
    def _finalFunc(self, position):
        final_func = sum(-position * np.sin(np.sqrt(np.abs(position))))
        penalty = self._getPenalty(position, 10000.0)

        return final_func + penalty
