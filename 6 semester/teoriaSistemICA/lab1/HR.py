from lab1.Person import Person


class HR(Person):
    def __init__(self,
                 f_name,
                 s_name,
                 l_name,
                 age,
                 sex,
                 company,
                 socials,
                 character):
        super().__init__(f_name, s_name, l_name, age, sex, company)
        self._character = character
        self._socials = socials

    @property
    def character(self):
        return self._character

    @property
    def socials(self):
        return self._socials

    @character.setter
    def character(self, value):
        self._character = value

    @socials.setter
    def socials(self, value):
        self._socials = value

    def __str__(self):
        return super().__str__() + """ Характер: {} Соц-сети: {}
        """.format(self.character,
                   ', '.join(self.socials))
