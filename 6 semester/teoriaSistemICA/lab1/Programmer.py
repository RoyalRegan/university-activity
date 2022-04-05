from lab1.Person import Person


class Programmer(Person):
    def __init__(self,
                 f_name,
                 s_name,
                 l_name,
                 age,
                 sex,
                 company,
                 role,
                 languages,
                 position):
        super().__init__(f_name, s_name, l_name, age, sex, company)
        self._role = role
        self._languages = languages
        self._position = position

    @property
    def role(self):
        return self._role

    @property
    def languages(self):
        return self._languages

    @property
    def position(self):
        return self._position

    @role.setter
    def role(self, value):
        self._role = value

    @languages.setter
    def languages(self, value):
        self._languages = value

    @position.setter
    def position(self, value):
        self._position = value

    def __str__(self):
        return super().__str__() + """ Роль: {} Языки: {} Позиция: {}
        """.format(self.role,
                   ', '.join(self.languages),
                   self.position)
