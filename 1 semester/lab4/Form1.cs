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

        int[] m = new int[10];
        int[] md = { };
        int inputCount = 0;
        

        private void button1_Click(object sender, EventArgs e)
        {
            int a;
            if (int.TryParse(textBox1.Text, out a))
            {
                if (inputCount == 10)
                    MessageBox.Show("максимальное кол-во элементов в массиве", "Ошибка", MessageBoxButtons.OK, MessageBoxIcon.Error);
                else
                {
                    m[inputCount] = a;
                    label1.Text += m[inputCount].ToString() + ", ";
                    inputCount++;
                }
            }
        }
        private void button2_Click(object sender, EventArgs e)
        {
            int a = int.Parse(textBox2.Text);
            int[] new_md = new int[md.Length + 1];
            md.CopyTo(new_md, 0);
            md = new_md;
            md[md.Length - 1] = a;
            label2.Text += a.ToString() + ", ";
        }

        private void button3_Click(object sender, EventArgs e)
        {
            m = new int[10];
            inputCount = 0;
            label1.Text = "";
        }

        private void button4_Click(object sender, EventArgs e)
        {
            md = new int[0];
            label2.Text = "";
        }

        private void button5_Click(object sender, EventArgs e)
        {
            {
                {
                    int s = 1;
                    foreach (int value in m)
                        s *= value;
                    MessageBox.Show("Произведение(статический): " + s.ToString());
                }

                {
                    int s = 1;
                    foreach (int value in md)
                        s *= value;
                    MessageBox.Show("Произведение(динамический): " + s.ToString());
                }
            }

            {

                {
                    int max1 = -999999999;
                    int max2 = -999999999;
                    int s = 0;
                    int c = -1;
                    for (int i = 0; i < m.Length; i++)

                        if(max1 < m[i] && m[i] % 2 == 0)
                        {
                            max1 = m[i];
                            c = i;
                        }

                    for (int i = 0; i < m.Length; i++)
                        if (max2 < m[i] && m[i] % 2 == 0 && c != i)
                            max2 = m[i];
                    if (max1 == -999999999 || max2 == -999999999)
                        s = 0;
                    else
                    s = max1 * max2;
                    MessageBox.Show("Произведение 2-х максимальных четных элементов(статический): " + s.ToString());

                }

                {
                    int max1 = -999999999;
                    int max2 = -999999999;
                    int s = 0;
                    int c = -1;
                    for (int i = 0; i < md.Length; i++)

                        if (max1 < md[i] && md[i] % 2 == 0)
                        {
                            max1 = md[i];
                            c = i;
                        }

                    for (int i = 0; i < md.Length; i++)
                        if (max2 < md[i] && md[i] % 2 == 0 && c != i)
                            max2 = md[i];
                    if (max1 == -999999999 || max2 == -999999999)
                        s = 0;
                    else
                        s = max1 * max2;
                    MessageBox.Show("Произведение 2-х максимальных четных элементов(динамический): " + s.ToString());
                }    
                
            }

            {
                {
                    int s = 0;
                    for (int i = 0; i < m.Length; i++, i++)
                        s += m[i];
                    MessageBox.Show("Сумма элементов с четными индексами(статический): " + s.ToString());
                }
                {

                    int s = 0;
                    for (int i = 0; i < md.Length; i++, i++)
                        s += md[i];
                    MessageBox.Show("Сумма элементов с четными индексами(динамический): " + s.ToString());

                }
            }

            {
                {
                    {
                        int s = 0;
                        int c = 0;
                        int count = 0;
                        double k = 0;
                        for (int i = 0; i < m.Length; i++)
                        {
                            if (m[i] < 0)
                            {
                                s += m[i];
                                count++;
                            }
                        }
                            if (count != 0)
                                k = s / count;
                            for (int i = 0; i < m.Length; i++)
                            
                                if (m[i] < k)
                                    c++;
        
                            
                        MessageBox.Show("количество элементов меньших среднего отрицательного(cтатический): " + c.ToString());
                    }

                    {
                        int s = 0;
                        int c = 0;
                        int count = 0;
                        double k = 0;
                        for (int i = 0; i < md.Length; i++)
                        {
                            if (md[i] < 0)
                            {
                                s += md[i];
                                count++;
                            }
                        }
                        if (count != 0)
                            k = s / count;
                        for (int i = 0; i < md.Length; i++)
                        
                            if (md[i] < k)
                                c++;

                        
                        MessageBox.Show("количество элементов меньших среднего отрицательного(динамический): " + c.ToString());
                    }

                }
            }

        }
    
        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
