from abc import ABC


class Person(ABC):
    def __init__(self,
                 f_name,
                 s_name,
                 l_name,
                 age,
                 sex,
                 company):
        self._f_name = f_name
        self._s_name = s_name
        self._l_name = l_name
        self._age = age
        self._sex = sex
        self._company = company

    @property
    def f_name(self):
        return self._f_name

    @property
    def s_name(self):
        return self._s_name

    @property
    def l_name(self):
        return self._l_name

    @property
    def age(self):
        return self._age

    @property
    def sex(self):
        return self._sex

    @property
    def company(self):
        return self._company

    @f_name.setter
    def f_name(self, value):
        self._f_name = value

    @s_name.setter
    def s_name(self, value):
        self._s_name = value

    @l_name.setter
    def l_name(self, value):
        self._l_name = value

    @age.setter
    def age(self, value):
        self._age = value

    @sex.setter
    def sex(self, value):
        self._sex = value

    @company.setter
    def company(self, value):
        self._company = value

    def __str__(self):
        return """
        Имя: {} Фамилия: {} Отчество: {} Возраст: {} Пол: {} Компания: {}
        """.format(self.f_name,
                   self.s_name,
                   self.l_name,
                   self.age,
                   self.sex,
                   self.company)

    def __repr__(self):
        return str(self)
