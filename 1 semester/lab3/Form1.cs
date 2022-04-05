using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;


namespace Лаба3
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

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

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

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
        private void button1_Click(object sender, EventArgs e)
        {
            {
                {
                    int a, b, res;
                    if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                    {
                        res = a + b;
                        listBox1.Items.Add(textBox1.Text + "+" + textBox2.Text + "=" + res.ToString());
                    }
                    else
                    {
                        double a1, b1, res1;
                        if (double.TryParse(textBox1.Text, out a1) && double.TryParse(textBox2.Text, out b1))
                        {
                            res1 = a1 + b1;
                            listBox1.Items.Add(textBox1.Text + "+" + textBox2.Text + "=" + res1.ToString());
                        }
                        else
                        {
                            MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }
                    }
                }
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            {
                {
                    int a, b, res;
                    if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                    {
                        res = a - b;
                        listBox1.Items.Add(textBox1.Text + "-" + textBox2.Text + "=" + res.ToString());
                    }
                    else
                    {
                        double a1, b1, res1;
                        if (double.TryParse(textBox1.Text, out a1) && double.TryParse(textBox2.Text, out b1))
                        {
                            res1 = a1 - b1;
                            listBox1.Items.Add(textBox1.Text + "-" + textBox2.Text + "=" + res1.ToString());
                        }
                        else
                        {
                            MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }
                    }
                }
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            {
                {
                    int a, b, res;
                    if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                    {
                        res = a * b;
                        listBox1.Items.Add(textBox1.Text + "*" + textBox2.Text + "=" + res.ToString());
                    }
                    else
                    {
                        double a1, b1, res1;
                        if (double.TryParse(textBox1.Text, out a1) && double.TryParse(textBox2.Text, out b1))
                        {
                            res1 = a1 * b1;
                            listBox1.Items.Add(textBox1.Text + "*" + textBox2.Text + "=" + res1.ToString());
                        }
                        else
                        {
                            MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }
                    }
                }
            }
        }

        private void button4_Click(object sender, EventArgs e)
        {
            {
                {
                    int a, b, res;
                    if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                
                        if (b != 0)
                        {

                            res = a / b;
                            listBox1.Items.Add(textBox1.Text + "/" + textBox2.Text + "=" + res.ToString());
                        }
                        else
                        {
                            double a1, b1, res1;
                            if (double.TryParse(textBox1.Text, out a1) && double.TryParse(textBox2.Text, out b1))
                            {
                                res1 = a1 / b1;
                                listBox1.Items.Add(textBox1.Text + "/" + textBox2.Text + "=" + res1.ToString());
                            }
                            else
                            {
                                MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                            }
                        }
                }
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            {
                {
                    int a, b, res;
                    if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                        if (b != 0)
                        {
                            {
                                res = a % b;
                                listBox1.Items.Add(textBox1.Text + "%" + textBox2.Text + "=" + res.ToString());
                            }
                        }
                            else
                            {
                               MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                            }
                    else
                    {
                        double a1, b1, res1;
                        if (double.TryParse(textBox1.Text, out a1) && double.TryParse(textBox2.Text, out b1))
                        {
                            res1 = a1 % b1;
                            listBox1.Items.Add(textBox1.Text + "%" + textBox2.Text + "=" + res1.ToString());
                        }
                        else
                        {
                            MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }
                    }
                }
            }
        }

        private void button6_Click(object sender, EventArgs e)
        {
            {
                {
                    int a, b, res;
                    if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                    {
                        res = a & b;
                        listBox1.Items.Add(textBox1.Text + "&" + textBox2.Text + "=" + res.ToString());
                    }
                    else
                    {
                        bool a1, b1, res1;


                        if (bool.TryParse(textBox1.Text, out a1) && bool.TryParse(textBox2.Text, out b1))
                        {

                            res1 = a1 & b1;
                            listBox1.Items.Add(textBox1.Text + "&" + textBox2.Text + "=" + res1.ToString());
                        }

                        else
                        {
                            MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }
                    }
                }
            }
        }

        private void button7_Click(object sender, EventArgs e)
        {
            {
                {
                    int a, b, res;
                    if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                    {
                        res = a | b;
                        listBox1.Items.Add(textBox1.Text + "|" + textBox2.Text + "=" + res.ToString());
                    }
                    else
                    {
                        bool a1, b1, res1;


                        if (bool.TryParse(textBox1.Text, out a1) && bool.TryParse(textBox2.Text, out b1))
                        {

                            res1 = a1 | b1;
                            listBox1.Items.Add(textBox1.Text + "|" + textBox2.Text + "=" + res1.ToString());
                        }

                        else
                        {
                            MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }
                    }
                }
            }
        }

        private void button8_Click(object sender, EventArgs e)
        {
            {
                {
                    int a, b, res;
                    if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                    {
                        res = a ^ b;
                        listBox1.Items.Add(textBox1.Text + "^" + textBox2.Text + "=" + res.ToString());
                    }
                    else
                    {
                        bool a1, b1, res1;


                        if (bool.TryParse(textBox1.Text, out a1) && bool.TryParse(textBox2.Text, out b1))
                        {

                            res1 = a1 ^ b1;
                            listBox1.Items.Add(textBox1.Text + "^" + textBox2.Text + "=" + res1.ToString());
                        }

                        else
                        {
                            MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }
                    }
                }
            }
        }

        private void button9_Click(object sender, EventArgs e)
        {
            {
                {
                    {
                        int a, b, res;
                        if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                        {
                            res = ~(a * b);
                            listBox1.Items.Add("~" + "(" + textBox1.Text + "*" + textBox2.Text + ")" + "=" + res.ToString());
                        }
                        else
                        {
                            bool a1, b1, res1;


                            if (bool.TryParse(textBox1.Text, out a1) && bool.TryParse(textBox2.Text, out b1))
                            {

                                res1 = !(a1 & b1);
                                listBox1.Items.Add("!" + "(" + textBox1.Text + "&" + textBox2.Text + ")" + "=" + res1.ToString());
                            }

                            else
                            {
                                MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                            }
                        }
                    }
                }
            }
        }

        private void button10_Click(object sender, EventArgs e)
        {
            {
                {
                    { int a, b;
                       bool res;
                        if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                        {
                            res = (a > b);
                            listBox1.Items.Add(textBox1.Text + ">" + textBox2.Text + "=" + res.ToString());
                        }
                        else
                        {
                            double a1, b1;
                            bool res1;
                            if (double.TryParse(textBox1.Text, out a1) && double.TryParse(textBox2.Text, out b1))
                            {
                                res1 = (a1 > b1);
                                listBox1.Items.Add(textBox1.Text + ">" + textBox2.Text + "=" + res1.ToString());
                            }
                            else
                            {
                                MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                            }

                        }
                    }
                }
            }
        }
        private void button11_Click(object sender, EventArgs e)
        {
            {
                {
                    int a, b;
                    bool res;
                    if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                    {
                        res = (a < b);
                        listBox1.Items.Add(textBox1.Text + "<" + textBox2.Text + "=" + res.ToString());
                    }
                    else
                    {
                        double a1, b1;
                        bool res1;
                        if (double.TryParse(textBox1.Text, out a1) && double.TryParse(textBox2.Text, out b1))
                        {
                            res1 = (a1 < b1);
                            listBox1.Items.Add(textBox1.Text + "<" + textBox2.Text + "=" + res1.ToString());
                        }
                        else
                        {
                            MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }

                    }
                }
            }
        }


        private void button12_Click(object sender, EventArgs e)

        {
            {
                {
                    int a, b;
                    bool res;
                    if
                    (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                    {
                        res = (a >= b);
                        listBox1.Items.Add(textBox1.Text + ">=" + textBox2.Text + "=" + res.ToString());
                    }
                    else
                    {
                        double a1, b1;
                        bool res1;
                        if (double.TryParse(textBox1.Text, out a1) && double.TryParse(textBox2.Text, out b1))
                        {
                            res1 = (a1 >= b1);
                            listBox1.Items.Add(textBox1.Text + ">=" + textBox2.Text + "=" + res1.ToString());
                        }
                        else
                        {
                            MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }

                    }
                }
            }
         }

        private void button13_Click(object sender, EventArgs e)
        {
            {
                {
                    int a, b;
                    bool res;
                    if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                    {
                        res = (a <= b);
                        listBox1.Items.Add(textBox1.Text + "<=" + textBox2.Text + "=" + res.ToString());
                    }
                    else
                    {
                        double a1, b1;
                        bool res1;
                        if (double.TryParse(textBox1.Text, out a1) && double.TryParse(textBox2.Text, out b1))
                        {
                            res1 = (a1 <= b1);
                            listBox1.Items.Add(textBox1.Text + "<=" + textBox2.Text + "=" + res1.ToString());
                        }
                        else
                        {
                            MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }

                    }
                }
            }
        }



        private void button14_Click(object sender, EventArgs e)
        {
            {
                {
                    int a, b;
                    bool res;
                    if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                    {
                        res = (a == b);
                        listBox1.Items.Add(textBox1.Text + "==" + textBox2.Text + "=" + res.ToString());
                    }
                    else
                    {
                        double a1, b1;
                        bool res1;
                        if (double.TryParse(textBox1.Text, out a1) && double.TryParse(textBox2.Text, out b1))
                        {
                            res1 = (a1 == b1);
                            listBox1.Items.Add(textBox1.Text + "==" + textBox2.Text + "=" + res1.ToString());
                        }
                        else
                        {
                            MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }

                    }
                }
            }
        }

        private void button15_Click(object sender, EventArgs e)
        {
            {
                {
                    int a, b, k;
                    bool res = false;
                    k = 1;
                    if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                    {
                        int j = a + b;
                        if (a + b >= 3)
                        {
                            while (a + b >= j)
                            {
                                if (a + b == Math.Pow(3, k))
                                {
                                    res = true;
                                    break;

                                }
                                j = (int)Math.Pow(3, k++);


                            }
                            if (res)
                            {
                                listBox1.Items.Add(a + b + " True" + " степень = " + k);
                            }
                            else
                            {
                                listBox1.Items.Add(a + b + " False");
                            }
                        }
                        else
                        {
                            if (a + b == 1)
                                listBox1.Items.Add(a + b + " True" + " степень = 0");
                            else
                                listBox1.Items.Add(a + b + " False");

                        }

                    }
                    else
                    {
                        MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }
            }

        }

        private void button16_Click(object sender, EventArgs e)
        {
            {
                {
                    double a, b, res;
                    if (double.TryParse(textBox1.Text, out a) && double.TryParse(textBox2.Text, out b))
                    {
                        res = a + b;
                        res = (double)Math.Cos(res);
                        listBox1.Items.Add("Cos" + (a + b) + "(rad)" + " = " + res.ToString());
                    }
                    else
                    {
                        int a1, b1, res1;
                        if (int.TryParse(textBox1.Text, out a1) && int.TryParse(textBox2.Text, out b1))
                        {
                            res1 = a1 + b1;
                            res1 = (int)Math.Cos(res1);
                            listBox1.Items.Add("Cos" + (a1 + b1) + "(rad)" + " = " + res1.ToString());
                        }
                        else
                        {
                            MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }
                    }
                }
            }

        }

        private void button17_Click(object sender, EventArgs e)
        {
            {
                {
                    double a, b, res, x, y;
                    if (double.TryParse(textBox1.Text, out a) && double.TryParse(textBox2.Text, out b))
                    {
                        res = a + b;
                        x = (double)Math.Cos(res);
                        y = (double)Math.Sin(res);
                        res = x / y;
                        listBox1.Items.Add("Ctan" + (a + b) + "(rad)" + " = " + res.ToString());
                    }
                    else
                    {
                        int a1, b1, res1, x1, y1;
                        if (int.TryParse(textBox1.Text, out a1) && int.TryParse(textBox2.Text, out b1))
                        {
                            res1 = a1 + b1;
                            x1 = (int)Math.Cos(res1);
                            y1 = (int)Math.Sin(res1);
                            res1 = x1 / y1;
                            listBox1.Items.Add("Ctan" + (a1 + b1) + "(rad)" + " = " + res1.ToString());
                        }
                        else
                        {
                            MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);
                        }
                    }

                }
            }
            
        }
        
        private void button18_Click(object sender, EventArgs e)
        {
            {
                {
                    int a, b, res;
                    if (int.TryParse(textBox1.Text, out a) && int.TryParse(textBox2.Text, out b))
                    {
                        res = (int)Math.Pow(a, b);
                        listBox1.Items.Add(textBox1.Text + " ^ " + textBox2.Text + " = " + res.ToString());
                    }
                    else
                    {
                        double a1, b1, res1;
                        if (double.TryParse(textBox1.Text, out a1) && double.TryParse(textBox2.Text, out b1))
                        {
                            res1 = (double)Math.Pow(a1, b1);
                            listBox1.Items.Add(textBox1.Text + " ^ " + textBox2.Text + " = " + res1.ToString());
                        }
                        else
                        {
                            MessageBox.Show("Неверные аргументы", "Ошибка ввода", MessageBoxButtons.OK, MessageBoxIcon.Error);

                        }
                    }
                }
            }
        }

        private void button19_Click(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
        }
    }
}
            
                
 
