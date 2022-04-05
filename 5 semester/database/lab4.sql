--Проекция
select distinct fio, male from sportsmen;

--Выборка
select * from sportsmen
    where male = 'ж';

--Умножение
select *
from sportsmen
         cross join trainer;

--Соединение
select *
from sportsmen
         inner join trainer t on sportsmen.trainer_id = t.id;

--Пересечение
select *
from sportsmen
where male = 'ж'
	intersect
select *
from sportsmen

--Вычитание
select *
from sportsmen
    except
select *
from sportsmen
where male = 'ж'

--Объединение
select *
from sportsmen
where male = 'ж'
union
select *
from sportsmen
where male = 'м';

--Деление
select *
from sportsmen
group by certificate_id, male
having male = 'ж';