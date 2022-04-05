using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Лаба7
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

        double c = 0;

        public class MylistItem
        {
            public int Data;
            public MylistItem Next;
        }

        public MylistItem Head;

        public MylistItem Tail;

        public void AddFirst(int data)
        {
            if (Head == null)
            {
                Head = new MylistItem();
                Head.Data = data;
                Tail = Head;
            }
            else
            {
                MylistItem second = Head;
                Head = new MylistItem();
                Head.Next = second;
                Head.Data = data;
            }
        }

        public void RemoveFirst()
        {
            if (Head != null)
            {
                MylistItem remove = new MylistItem();
                Head = Head.Next;
            }
        }

        public void RemoveLast()
        {
            if (Head != null)
            {
                MylistItem remove = Head;

                for (; remove.Next != Tail; remove = remove.Next)
                {
                    if (Head == Tail)
                    {
                        Head = null;
                        break;
                    }
                }

                Tail = remove;
                Tail.Next = null;
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int StartT, FinishT;
            StartT = Environment.TickCount;

            for (int i = 0; i < 25000; i++)
            {
                AddFirst(i);
            }

            for (int i = 0; i < 25000; i++)
            {
                RemoveLast();
            }

            FinishT = Environment.TickCount - StartT;
            c = FinishT / 1000.0;
            listBox1.Items.Add("Время затрачиваемое на выполнение первой операции (сек): "+c);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            int StartT, FinishT;
            LinkedList<int> a = new LinkedList<int>();
            StartT = Environment.TickCount;

            for (int i = 0; i < 2500000; i++)
            {
                a.AddFirst(i);
            }

            for (int i = 0; i < 2500000; i++)
            {
                a.RemoveFirst();
            }

            FinishT = Environment.TickCount - StartT;
            c = FinishT / 1000.0;
            listBox1.Items.Add("Время затрачиваемое на выполнение второй операции (сек): " + c);
        }

        private void button3_Click(object sender, EventArgs e)
        {
            int StartT, FinishT;
            LinkedList<int> a = new LinkedList<int>();
            StartT = Environment.TickCount;


            for (int i = 0; i < 2500000; i++)
            {
                a.AddFirst(i);
            }

            for (int i = 0; i < 2500000; i++)
            {
                a.RemoveFirst();
            }

            FinishT = Environment.TickCount - StartT;
            c = FinishT / 1000.0;
            listBox1.Items.Add("Время затрачиваемое на выполнение третей операции (сек): " + c);
        }

        private void button4_Click(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
        }
    }
}

    

