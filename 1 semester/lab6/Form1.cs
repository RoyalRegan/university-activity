using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Лаба6
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

        private void button1_Click(object sender, EventArgs e)
        {
            String s = textBox1.Text;
            int count = 0;
            for (int i = 0; i < s.Length; i++)
                if ((s[i] >= 'А' && s[i] <= 'Я') | ((s[i] >= 'а') && (s[i] <= 'я')))
                    count++;
            listBox1.Items.Add("Кол-во русских букв: " + count.ToString());
        }

        private void button2_Click(object sender, EventArgs e)
        {
            StringBuilder s = new StringBuilder(textBox1.Text);
            s.Replace("abc", "ПРЕВЕД");
            listBox1.Items.Add("abc заменили на ПРЕВЕД: " + s.ToString());
        }

        private void button3_Click(object sender, EventArgs e)
        {
            int count = 0;
            string s = textBox1.Text;
            string k = null;
            for (int i = 0; i < s.Length; i++)
            {
                if (char.IsNumber(s[i]))
                    k += s[i];
                else if (k != null)
                {
                    k = null;
                    count++;
                }
            }
            if (k != null)
            {
                count++;
            }
            listBox1.Items.Add("Кол-во чисел в строке: " + count.ToString());
        }

        private void button4_Click(object sender, EventArgs e)
        {
            StringBuilder s = new StringBuilder(textBox1.Text);
            int count = 0;
            for (int i = 0; i < s.Length; i++)
            {
                if (s[i] == '.')
                {
                    count++;
                    if (count % 3 == 0)
                        s[i] = ':';
                }
            }
            listBox1.Items.Add("Каждая 3-я точка, двоеточие: " + s.ToString());
        }
        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}
  
