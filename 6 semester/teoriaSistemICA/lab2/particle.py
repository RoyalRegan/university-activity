from comtypes.safearray import numpy as np


class Particle(object):

    def __init__(self, swarm):
        self.__currentPosition = self.__getInitPosition(swarm)

        self.__localBestPosition = self.__currentPosition[:]

        self.__localBestFinalFunc = swarm.getFinalFunc(self.__currentPosition)

        self.velocity = self.__getInitVelocity(swarm)

    @property
    def position(self):
        return self.__currentPosition

    @staticmethod
    def __getInitPosition(swarm):
        return np.random.rand(swarm.dimension) * (swarm.max_values - swarm.min_values) + swarm.min_values

    def __getInitVelocity(self, swarm):
        assert len(swarm.min_values) == len(self.__currentPosition)
        assert len(swarm.max_values) == len(self.__currentPosition)

        min_val = -(swarm.max_values - swarm.min_values)
        max_val = (swarm.max_values - swarm.min_values)

        return np.random.rand(swarm.dimension) * (max_val - min_val) + min_val

    def nextIteration(self, swarm):
        rnd_current_best_position = np.random.rand(swarm.dimension)

        rnd_global_best_position = np.random.rand(swarm.dimension)

        velocity_ratio = swarm.local_velocity_ratio + swarm.global_velocity_ratio
        common_ratio = (2.0 * swarm.current_velocity_ratio /
                        (np.abs(2.0 - velocity_ratio - np.sqrt(velocity_ratio ** 2 - 4.0 * velocity_ratio))))

        new_velocity_part1 = common_ratio * self.velocity

        new_velocity_part2 = (common_ratio *
                              swarm.local_velocity_ratio *
                              rnd_current_best_position *
                              (self.__localBestPosition - self.__currentPosition))

        new_velocity_part3 = (common_ratio *
                              swarm.global_velocity_ratio *
                              rnd_global_best_position *
                              (swarm.global_best_position - self.__currentPosition))

        self.velocity = new_velocity_part1 + new_velocity_part2 + new_velocity_part3

        self.__currentPosition += self.velocity

        final_func = swarm.getFinalFunc(self.__currentPosition)
        if final_func < self.__localBestFinalFunc:
            self.__localBestPosition = self.__currentPosition[:]
            self.__localBestFinalFunc = final_func
