from lab1.Person import Person


class Manager(Person):
    def __init__(self,
                 f_name,
                 s_name,
                 l_name,
                 age,
                 sex,
                 company,
                 team_name,
                 direction):
        super().__init__(f_name, s_name, l_name, age, sex, company)
        self._direction = direction
        self._team_name = team_name

    @property
    def direction(self):
        return self._direction

    @property
    def team_name(self):
        return self._team_name

    @direction.setter
    def direction(self, value):
        self._direction = value

    @team_name.setter
    def team_name(self, value):
        self._team_name = value

    def __str__(self):
        return super().__str__() + """ Команда: {} Направление: {}
        """.format(self.team_name,
                   self.direction)
