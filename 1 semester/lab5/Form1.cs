using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Лаба5

{
   
    public partial class Form1 : Form
    {
       

        public Form1()
        {
            InitializeComponent();
        }

        struct Sotrudnik
        {
            public string Num;
            public string Fir;
            public string Sec;
            public string Otch;
            public int Year;
            public string Spec;
            public int Staz;
        }

        List<Sotrudnik> persons = new List<Sotrudnik>();

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Sotrudnik k;
            k.Num = textBox1.Text;
            k.Fir = textBox2.Text;
            k.Sec = textBox3.Text;
            k.Otch = textBox4.Text;
            k.Year = int.Parse(textBox5.Text);
            k.Spec = textBox6.Text;
            k.Staz = int.Parse(textBox7.Text);
            persons.Add(k);
            ListViewItem a = new ListViewItem();
            a.Text = k.Num.ToString();
            ListViewItem.ListViewSubItem b = new ListViewItem.ListViewSubItem();
            b.Text = k.Fir;
            ListViewItem.ListViewSubItem c = new ListViewItem.ListViewSubItem();
            c.Text = k.Sec;
            ListViewItem.ListViewSubItem d = new ListViewItem.ListViewSubItem();
            d.Text = k.Otch;
            ListViewItem.ListViewSubItem t = new ListViewItem.ListViewSubItem();
            t.Text = k.Year.ToString();
            ListViewItem.ListViewSubItem f = new ListViewItem.ListViewSubItem();
            f.Text = k.Spec;
            ListViewItem.ListViewSubItem g = new ListViewItem.ListViewSubItem();
            g.Text = k.Staz.ToString();
            listView1.Items.Add(a);
            a.SubItems.Add(b);
            a.SubItems.Add(c);
            a.SubItems.Add(d);
            a.SubItems.Add(t);
            a.SubItems.Add(f);
            a.SubItems.Add(g);
            
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (listView1.SelectedItems.Count > 0)
                listView1.Items.Remove(listView1.SelectedItems[0]);
           
            else
            {
                MessageBox.Show("Не один сотрудник не выделен", "Неверные аргументы", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

        }

        private void button3_Click(object sender, EventArgs e)
        {
            string s = null;

            foreach (Sotrudnik l in persons)

                if (l.Staz > int.Parse(textBox7.Text))

                {
                    s += " " + l.Num + " ";
                }

            MessageBox.Show(s);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            string s = null;

            foreach (Sotrudnik l in persons)
                if (l.Spec == (textBox6.Text))

                {
                    s += " "+l.Num+" ";
                }
 
            MessageBox.Show(s);

        }

        private void button5_Click(object sender, EventArgs e)
        {
            string s = null;
            for (int i = 0; i < persons.Count; i++)
            {
                for (int j = i + 1; j < persons.Count; j++)
                {
                    if (persons[i].Staz == persons[j].Staz && persons[i].Year == persons[j].Year)
                    {
                        s += persons[i].Num + " " + persons[j].Num + " ";
                    }

                }
            }

            MessageBox.Show(s);
        }

        private void button6_Click(object sender, EventArgs e)
        {

            string s = null;
            for (int i = 0; i < persons.Count; i++)
            {
                for (int j = i + 1; j < persons.Count; j++)
                {
                    if (persons[i].Spec == persons[j].Spec && persons[i].Staz == persons[j].Staz)
                    {
                        s += persons[i].Num + " " + persons[j].Num + " ";
                    }
                   
                }
            }

            MessageBox.Show(s);
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox5_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox6_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox7_TextChanged(object sender, EventArgs e)
        {

        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

    }

}
