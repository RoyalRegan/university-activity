using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        static int[] mas;
        int[] m = { };
        int b = 0;
        int M;
        int N;
        int count = 0;
        string s = null;

        private void button1_Click(object sender, EventArgs e) //Ручное добавление элемента в массив 
        {
            int a = 0;
            if (int.TryParse(textBox4.Text, out b))
                if (b > 0)
                {
                    if (textBox1.Text != "")
                    {
                        if (int.TryParse(textBox1.Text, out a))
                        {
                            if ((b <= 100) && (b != 0))
                            {
                                if (count < b)
                                {
                                    int[] new_m = new int[m.Length + 1];
                                    m.CopyTo(new_m, 0);
                                    m = new_m;
                                    m[m.Length - 1] = a;
                                    count++;
                                    label2.Text += a.ToString() + " ";//Вывод массива на экран 
                                    if (count == b)
                                    {
                                        textBox4.ReadOnly = true;
                                    }
                                    textBox1.Clear();
                                }
                                else MessageBox.Show("Количество элементов не должно превышать: " + b, "Добавить", MessageBoxButtons.OK, MessageBoxIcon.Error);
                            }
                            else
                                MessageBox.Show("Макисмальная длина 100 элементов, длина не может равняться 0", "Добавить", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }
                        else
                            MessageBox.Show("Неверный тип данных", "Добавить", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                    else
                        MessageBox.Show("Пустое окно", "Добавить", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                else
                    MessageBox.Show("Количество элементов не может быть равно: " + b, "Добавить", MessageBoxButtons.OK, MessageBoxIcon.Error);
            else
                MessageBox.Show("Введите длину массива", "Добавить", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        private void button2_Click(object sender, EventArgs e) // Удаление повторяющихся элементов 
        {
            s = null;
            if (int.TryParse(textBox4.Text, out b)&&(m.Length!=0))
            {
                if (count == b)
                {
                    int[] result = m.Distinct().ToArray();
                    m = result;

                    for (int i = 0; i < m.Length; i++)//вывод массива на экран
                        s += m[i].ToString() + " ";
                    label2.Text += "\n" + "Удаление повторяющихся элементов: " + "\n" + s;
                    count = m.Length;
                    textBox4.Text = count.ToString();
                }
                else
                    MessageBox.Show("Массив введен не полностью", "Удал повтор элем", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
                MessageBox.Show("Введите массив", "Удал повтор элем", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        private void button3_Click(object sender, EventArgs e) // Сортировка(пузырь)
        {
            s = null;
            if (int.TryParse(textBox4.Text, out b) && (m.Length != 0))
            {
                if (count == b)
                {
                    if (m.Length != 0)
                    {
                        for (int i = 0; i < m.Length; i++)
                        {
                            for (int j = 0; j < m.Length - i - 1; j++)
                            {
                                if (m[j] > m[j + 1])
                                {
                                    int temp = m[j];
                                    m[j] = m[j + 1];
                                    m[j + 1] = temp;
                                }
                            }
                        }
                        for (int i = 0; i < m.Length; i++)//вывод массива на экран
                            s += m[i].ToString() + " ";
                        label2.Text += "\n" + "Сортировка(пузырь): " + "\n" + s;
                    }
                    else
                        MessageBox.Show("Введите массив", "Сортировка: пузырь", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                else
                    MessageBox.Show("Массив введен не полностью", "Сортировка: пузырь", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
                MessageBox.Show("Введите массив", "Сортировка: пузырь", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        static void QuickSort(int left, int rigth)// Сортировка(Хоар) подпрограмма
        {
            int pivot = Partition(left, rigth);
            if (left < pivot - 1)
                QuickSort(left, pivot - 1);
            if (pivot < rigth)
                QuickSort(pivot, rigth);
        }

        static int Partition(int left, int rigth)
        {
            int pivot = mas[(left + rigth) / 2];
            while (left <= rigth)
            {
                while (mas[left] < pivot)
                    left++;
                while (mas[rigth] > pivot)
                    rigth--;
                if (left <= rigth)
                {
                    int buf = mas[left];
                    mas[left] = mas[rigth];
                    mas[rigth] = buf;
                    left++;
                    rigth--;
                }
            }
            return left;
        }

        private void button4_Click(object sender, EventArgs e)// Сортировка(Хоар)
        {
            if (int.TryParse(textBox4.Text, out b) && (m.Length != 0))
            {
                if (count == b)
                {
                    s = null;
                    if (m.Length != 0)
                    {
                        mas = m;
                        QuickSort(0, count - 1);
                        for (int i = 0; i < m.Length; i++)//вывод массива на экран
                            s += m[i].ToString() + " ";
                        label2.Text += "\n" + "Сортировка(Хоар): " + "\n" + s;
                    }
                    else
                        MessageBox.Show("Введите массив", "Сортировка: Хоар", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                else
                    MessageBox.Show("Массив введен не полностью", "Сортировка: Хоар", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
                MessageBox.Show("Введите массив", "Сортировка: Хоар", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }
        private void button5_Click(object sender, EventArgs e) // Нахождение N-го максимума
        {
            if (int.TryParse(textBox4.Text, out b) && (m.Length != 0))// Сортировка на тот случай если массив не отсортирован
            {
                if (count == b)
                {
                    for (int i = 0; i < m.Length; i++)
                    {
                        for (int j = 0; j < m.Length - i - 1; j++)
                        {
                            if (m[j] > m[j + 1])
                            {
                                int temp = m[j];
                                m[j] = m[j + 1];
                                m[j + 1] = temp;
                            }
                        }
                    }
                    // нахождение максимума
                    int N1 = 0;
                    if (textBox2.Text != "")
                    {
                        if (int.TryParse(textBox2.Text, out N))
                        {
                            if (N > 0)
                                if (m.Length >= N)
                                {
                                    N1 = m[m.Length - N];
                                    label2.Text += "\n" + N + "-ый максимум: " + N1;//вывод максимума
                                }
                                else
                                {
                                    MessageBox.Show("Максимум не существует", "Нахожд N-го макс", MessageBoxButtons.OK, MessageBoxIcon.Error);
                                }
                            else
                                MessageBox.Show("Максимум не может равняться: " + N, "Нахожд N-го макс", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }
                        else
                            MessageBox.Show("Неверный тип данных", "Нахожд N-го макс", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                    else
                        MessageBox.Show("Пустое окно", "Нахожд N-го макс", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                else
                    MessageBox.Show("Массив введен не полностью", "Нахожд N-го макс", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
                MessageBox.Show("Введите массив", "Нахожд N-го макс", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        private void button6_Click(object sender, EventArgs e) //Нахождение M-го минимума
        {
            if (int.TryParse(textBox4.Text, out b) && (m.Length != 0)) // Сортировка на тот случай если массив не отсортирован
            {
                if (count == b)
                {
                    for (int i = 0; i < m.Length; i++)
                    {
                        for (int j = 0; j < m.Length - i - 1; j++)
                        {
                            if (m[j] > m[j + 1])
                            {
                                int temp = m[j];
                                m[j] = m[j + 1];
                                m[j + 1] = temp;
                            }
                        }
                    }
                    // нахождение минимума
                    int M1 = 0;
                    if (textBox3.Text != "")
                    {
                        if (int.TryParse(textBox3.Text, out M))
                        {
                            if (M > 0)
                                if (m.Length >= M)
                                {
                                    M1 = m[M - 1];
                                    label2.Text += "\n" + M + "-ый минимум: " + M1;//вывод минимума на экран
                                }
                                else
                                {
                                    MessageBox.Show("Минимум не существует", "Нахожд M-го мин", MessageBoxButtons.OK, MessageBoxIcon.Error);
                                }
                            else
                                MessageBox.Show("Минимум не может равняться: " + M, "Нахожд M-го мин", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }
                        else
                            MessageBox.Show("Неверный тип данных", "Нахожд M-го мин", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                    else
                        MessageBox.Show("Пустое окно", "Нахожд M-го мин", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                else
                    MessageBox.Show("Массив введен не полностью", "Нахожд M-го мин", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
                MessageBox.Show("Введите массив", "Нахожд M-го мин", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }
        private void button7_Click(object sender, EventArgs e) //Заполнение массива случайными числами 
        {
            s = null;
            label2.Text = null;
            if (textBox4.Text != "")
            {
                if (int.TryParse(textBox4.Text, out b))
                {
                    if (b > 0)
                    {
                        if ((b <= 100) && (b > 0))
                        {
                            int[] array = new int[b];
                            Random rand = new Random();
                            for (int i = 0; i < array.Length; i++)
                                array[i] = rand.Next(-100, 100);
                            for (int i = 0; i < array.Length; i++)//вывод массива на экран
                                s += array[i].ToString() + " ";
                            label2.Text += s;
                            m = array;
                            count = b;
                            textBox4.ReadOnly = true;
                            button7.Enabled = false;
                        }
                        else
                            MessageBox.Show("Макисмальная длина 100 элементов, длина не может равняться 0", "Заполн случ числ", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                    else
                        MessageBox.Show("Количество элементов не может быть равно: " + b, "Добавить", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                else
                    MessageBox.Show("Неверный тип данных", "Заполн случ числ", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
                MessageBox.Show("Введите длину массива", "Заполн случ числ", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        private void button8_Click(object sender, EventArgs e) // Сброс программы
        {
            m = new int[0];
            s = null;
            label2.Text = null;
            count = 0;
            textBox1.Text = null;
            textBox2.Text = null;
            textBox3.Text = null;
            textBox4.Text = null;
            textBox4.ReadOnly = false;
            button7.Enabled = true;
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {

        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}

