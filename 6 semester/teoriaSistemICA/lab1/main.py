from lab1.HR import HR
from lab1.Manager import Manager
from lab1.Programmer import Programmer
from lab1.Lawyer import Lawyer

if __name__ == "__main__":
    hrs = [HR('Павлик', 'Эдуардович', 'Устин', 21, 'M', 'ООО СТРОЙГАЙЗ', ['vk', 'facebook'], 'интроверт'),
           HR('Федот', 'Евгений', 'Брониславович', 41, 'M', 'ООО СТРОЙГАЙЗ', ['vk', 'odnoklassniki'], 'экстраврет'),
           HR('Татьяна ', 'Андреевна', 'Червона', 31, 'Ж', 'FitnessHeaven', ['vk', 'instagram', 'telegram'],
              'экстраверт')]

    programmes = [Programmer('Ким', 'Романович', 'Бердник ', 24, 'M', 'ООО СТРОЙГАЙЗ', 'Junior', ['java'], 'backend'),
                  Programmer('Владимир', 'Виталиевич', 'Захарченко ', 35, 'M', 'Райфайзен', 'Guru',
                             ['java', 'python', 'PL/SQL'], 'backend'),
                  Programmer('Марина', 'Алексеевна', 'Князева', 30, 'Ж', 'Сбербанк',
                             'Middle',
                             ['java', 'javascript'], 'full_stack')]

    managers = [Manager('Ярослав', 'Богданович', 'Авдеев ', 22, 'M', 'Qiwi', 'feature-team', 'интеграция'),
                Manager('Федер', 'Данилович', 'Никифоров ', 41, 'M', 'Qiwi', 'qwcore',
                        'интеграция'),
                Manager('Доминика', 'Андреевна', 'Лукина', 19, 'Ж', 'Сбербанк', 'mobile',
                        'поддержка')]

    lawyers = [Lawyer('Владимир', 'Богданович', 'Спивак', 22, 'M', 'ООО КаменьБетон', False, 'жилищная'),
               Lawyer('Андревн', 'Михайловна', 'Чеслава', 41, 'Ж', 'ООО СТРОЙГАЙЗ', False,
                      'уголовная'),
               Lawyer('Мария', 'Леонидовна', 'Харитина', 31, 'Ж', 'УголовНет', False,
                      'административная')]

    persons = [item for sublist in [hrs, managers, lawyers, programmes] for item in sublist]
    print('Запрос 1 (Вывести всех людей женского пола):')
    print([person for person in persons if person.sex == 'Ж'])
    print('Запрос 2 (Вывести всех людей из компании ООО СТРОЙГАЙЗ):')
    print([person for person in persons if person.company == 'ООО СТРОЙГАЙЗ'])
    print('Запрос 3 (Вывести всех менеджеров из команда qwcore с направление интеграция):')
    print([person for person in managers if person.direction == 'интеграция' and person.team_name == 'qwcore'])
    print('Запрос 4 (Вывести всех программистов женского пола знающих java):')
    print([person for person in programmes if person.sex == 'Ж' and 'java' in person.languages])
    print('Запрос 5 (Вывести всех адвокатов консультантов):')
    print([person for person in lawyers if person.is_consultant])
    print('Запрос 6 (Вывести всех эйчаров старше 35):')
    print([person for person in hrs if person.age > 35])
    print('Запрос 7 (Вывести всех адвокатов чье имя заканчивается на я):')
    print([person for person in lawyers if person.f_name.endswith('я')])
