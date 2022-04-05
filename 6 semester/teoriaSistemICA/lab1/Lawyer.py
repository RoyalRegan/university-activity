from lab1.Person import Person


class Lawyer(Person):
    def __init__(self,
                 f_name,
                 s_name,
                 l_name,
                 age,
                 sex,
                 company,
                 is_consultant,
                 industry):
        super().__init__(f_name, s_name, l_name, age, sex, company)
        self._is_consultant = is_consultant
        self._industry = industry

    @property
    def is_consultant(self):
        return self._is_consultant

    @property
    def industry(self):
        return self._industry

    @is_consultant.setter
    def is_consultant(self, value):
        self._is_consultant = value

    @industry.setter
    def industry(self, value):
        self._industry = value

    def __str__(self):
        return super().__str__() + """ Консультант: {} Индустртя: {}
        """.format(self.is_consultant,
                   self.industry)
