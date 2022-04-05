from comtypes.safearray import numpy as np
from lab2.swarm import Schefell_Swarm
import matplotlib.pyplot as plt

if __name__ == "__main__":
    iteration_count = 30
    dimension = 2
    swarm_size = 300

    min_values = np.array([-500] * dimension)
    max_values = np.array([500] * dimension)

    current_velocity_ratio = 0.5
    local_velocity_ratio = 2.0
    global_velocity_ratio = 5.0

    swarm = Schefell_Swarm(swarm_size,
                           min_values,
                           max_values,
                           current_velocity_ratio,
                           local_velocity_ratio,
                           global_velocity_ratio)

    for i in range(iteration_count):
        plt.clf()
        plt.xlim(-500, 500)
        plt.ylim(-500, 500)

        plt.scatter([s.position[0] for s in swarm], [s.position[1] for s in swarm])
        plt.show(block=False)
        plt.pause(0.3)
        swarm.nextIteration()

    print('Done')
    plt.show()
