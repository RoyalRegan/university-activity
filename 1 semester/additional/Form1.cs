using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Доп_задание
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        int[] m = { };
        int[] md = { };
        int[] sd = { };
        int k = 0;
        int g = 0;
        int q = 0;
        int c = 0;
        int b = 0;
        int count = 1;
        string s3 = null;
        string s4 = null;
        string s5 = null;

        private void button1_Click(object sender, EventArgs e)
        {
            int a;

            if (int.TryParse(textBox1.Text, out a))
            {
                int[] new_m = new int[m.Length + 1];
                m.CopyTo(new_m, 0);
                m = new_m;
                m[m.Length - 1] = a;
                label2.Text += a.ToString() + " ";
                textBox1.Clear();
            }
            else
                MessageBox.Show("Пустое окно ввода", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            bool p = false;
            for (int i = 0; i < m.Length - 1; i++)

                if ((m[i] < m[i + 1]))         
                {
                    p = true;
                    q = m[i + 1];
                    c = q;

                    int a = m[i];
                    int[] new_md = new int[md.Length + 1];
                    md.CopyTo(new_md, 0);
                    md = new_md;
                    md[md.Length - 1] = a;

                    s3 += m[i].ToString()+" ";   
                    count++;

                    if (count>b)
                        s4 = s3 + m[i + 1];
                }
                else
                {
                    if ((count > b) && (b != count))
                    {
                        int a = m[i];
                        int[] new_md = new int[md.Length + 1];
                        md.CopyTo(new_md, 0);
                        md = new_md;
                        md[md.Length - 1] = a;

                        b = count;
                        sd = md;
                        s3 += m[i].ToString() + " ";
                        s5 = s3;
                        s3 = null;
                        md = new int[0];
                        count = 1;
                    }
                    else
                    {
                        md = new int[0];
                        s3 = null;
                        count = 1;
                    }
                }

            if ((b > count) && (b != count))
            {
                md = sd;
                s3 = s5;
                count = b;
                g = md[md.Length-1];
            }
            else
            {
                g = c;
            }

            if (p == true)
            k = md[0];
            else
                MessageBox.Show("Пустое окно ввода", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);

            if (p == true)
                label2.Text += "\nПоследовательность:" + s4 + "\n Длина последовательности:" + count.ToString() + "\n Границы последовательности:"+k+" и "+g;
        }

        private void button3_Click(object sender, EventArgs e)
        {
                label2.Text += "\n";
                m = new int[0];
                md = new int[0];
                sd = new int[0];
                k = 0;
                g = 0;
                q = 0;
                c = 0;
                b = 0;
                count = 1;
                s3 = null;
                s4 = null;
                s5 = null;
            MessageBox.Show("Очищено", "Очистка массива", MessageBoxButtons.OK, MessageBoxIcon.Asterisk);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            label2.Text = "";
            MessageBox.Show("Очищено", "Очистка метки", MessageBoxButtons.OK, MessageBoxIcon.Asterisk);
        }

        private void label2_Click(object sender, EventArgs e)
        {
            
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
