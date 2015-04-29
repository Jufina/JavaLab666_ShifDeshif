package com.miet.mp34.samoshchenko.lab4;

import com.miet.mp34.samoshchenko.lab4.Calculate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Created by Julia on 27.03.2015.
 */
public class Calculator implements Calculate {
    public double result = 0;
    public double memory = 0;
    public double tempNum=0;
    public tempCom tc;
    public boolean isEq=false;
    public boolean isMultiEg=false;
    public enum tempCom {enter, plus, minus, divide, multiple, sqrt}

    boolean beg = true;

    public double plus(double p) {
        result += p;
        return result;
    }

    public double minus(double p) {
        result = result - p;
        return result;
    }

    public double divide(double p) {
        if (p != 0) {
            result = result / p;
        } else {
            result = 0;
        }
        return result;
    }

    public double multiple(double p) {
        result = result * p;
        return result;
    }

    public double sqroot(double p) {
        return Math.sqrt(p);
    }

    JButton pl = new JButton("+");
    JButton mi = new JButton("-");
    JButton dv = new JButton("/");
    JButton mp = new JButton("*");
    JButton sq = new JButton("sqrt");
    JButton eq = new JButton("=");
    JButton rst = new JButton("C");
    JButton mw = new JButton("MW");
    JButton mr = new JButton("MR");
    JButton bs = new JButton("<-");
    JButton po = new JButton(".");
    JButton[] numb = new JButton[10];

    JTextField str = new JTextField();
    JTextArea str2 = new JTextArea();

    public Calculator() {
        tc = tempCom.enter;
        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp = new JPanel();
        JPanel jp2 = new JPanel();


        pl.setBackground(Color.CYAN);
        mi.setBackground(Color.CYAN);
        dv.setBackground(Color.CYAN);
        mp.setBackground(Color.CYAN);
        sq.setBackground(Color.CYAN);
        eq.setBackground(Color.GREEN);
        bs.setBackground(Color.RED);
        rst.setBackground(Color.RED);
        mr.setBackground(Color.YELLOW);
        mw.setBackground(Color.YELLOW);
        jp.setBackground(Color.PINK);
        jp2.setBackground(Color.PINK);
        frame.setBackground(Color.PINK);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        //
        frame.setLayout(new GridLayout(2, 2));

        //jp2.setLayout(new GridLayout(7,2,2,2));
        jp2.setLayout(gbl);
        jp.setLayout(new GridBagLayout());
        frame.add(jp);
        frame.add(jp2);


        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.gridx = 1;
        constraints2.gridy = 1;
        constraints2.fill = GridBagConstraints.BOTH;
        constraints2.weighty = 0.2;
        constraints2.weightx = 0.2;

        //constraints2.insets=new Insets(50,30,50,30);
        Font myfont = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
        str.setFont(myfont);
        jp.add(str, constraints2);
        str.setHorizontalAlignment(SwingConstants.RIGHT);


        constraints.weightx = 0.2;
        constraints.weighty = 0.2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 1, 0, 1);

        constraints.gridy = 0;
        constraints.gridx = 0;
        jp2.add(pl, constraints);
        constraints.gridy = 0;
        constraints.gridx = 1;
        jp2.add(mi, constraints);
        constraints.gridy = 0;
        constraints.gridx = 2;
        jp2.add(dv, constraints);
        constraints.gridy = 0;
        constraints.gridx = 3;
        jp2.add(mp, constraints);


        constraints.gridy = 1;
        constraints.gridx = 0;
        jp2.add(sq, constraints);
        constraints.gridy = 1;
        constraints.gridx = 1;
        jp2.add(eq, constraints);
        constraints.gridy = 1;
        constraints.gridx = 2;
        jp2.add(bs, constraints);
        constraints.gridy = 1;
        constraints.gridx = 3;
        jp2.add(rst, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        jp2.add(mr, constraints);
        constraints.gridy = 2;
        constraints.gridx = 1;
        jp2.add(mw, constraints);


        str.setColumns(40);
        str2.setColumns(20);

        frame.setSize(600, 600);
        //root.setBounds(200,100,100,50);
        ActionListener actPlus = new PlusActList();
        ActionListener actMinus = new MinusActList();
        ActionListener actEqual = new EqualActList();
        ActionListener actSqroot = new SqrtActList();
        ActionListener actDivide = new DivideActList();
        ActionListener actMultiple = new MultipleActList();
        ActionListener actReset = new ResetActList();
        ActionListener actT = new TActList();
        ActionListener actMem = new MemActList();


        int ky = 3, kx = 0;
        for (int i = 9; i >= 0; i--) {
            if (kx == 3) {
                ky++;
                kx = 0;
            }
            if (i != 0) {
                constraints.gridy = ky;
                constraints.gridx = kx;
                numb[i] = new JButton();
                numb[i].setText(i + "");
                jp2.add(numb[i], constraints);
                numb[i].addActionListener(actT);
            } else {
                constraints.gridwidth = 2;
                constraints.gridy = ky;
                constraints.gridx = kx;
                numb[i] = new JButton();
                numb[i].setText(i + "");
                jp2.add(numb[i], constraints);
                numb[i].addActionListener(actT);
            }
            kx++;
        }
        constraints.gridy = ky;
        constraints.gridx = 2;
        constraints.gridwidth = 1;
        jp2.add(po, constraints);

        po.addActionListener(actT);
        pl.addActionListener(actPlus);
        mi.addActionListener(actMinus);
        dv.addActionListener(actDivide);
        mp.addActionListener(actMultiple);
        sq.addActionListener(actSqroot);
        eq.addActionListener(actEqual);
        bs.addActionListener(actReset);
        rst.addActionListener(actReset);
        mr.addActionListener(actMem);
        mw.addActionListener(actMem);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator cl = new Calculator();

    }

    public class TActList implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (beg) {
                str.setText("");
            }

            beg = false;
            Object source = e.getSource();
            if (source instanceof JButton) {
                JButton jb = (JButton) source;
                if ((str.getText().equals("0")) && (jb.getText().equals("."))) {
                    str.setText("0.");
                } else if (!(str.getText().equals("0"))) {
                    str.setText(str.getText() + jb.getText());
                } else {
                    str.setText("");
                    str.setText(str.getText() + jb.getText());
                }
            }

        }
    }

    public class ResetActList implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            isMultiEg=false;
            Object source = e.getSource();
            if (source instanceof JButton) {
                JButton jb = (JButton) source;
                if (jb.getText().equals("C")) {
                    tc = tempCom.enter;
                    result = 0;
                    str.setText("");
                    str2.setText("");
                } else {
                    str.setText(str.getText().substring(0, str.getText().length() - 1));
                }

            }
        }
    }

    public class EqualActList implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           if(!(isMultiEg)) {
               tempNum = Double.parseDouble(str.getText());
               chk(tc);
               //tc = tempCom.enter;
               beg = true;
               isMultiEg=true;
           }
            else {
               chk(tc);
               //tc = tempCom.enter;
               beg = true;
           }
        }
    }

    public class MemActList implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            isMultiEg=false;
            Object source = e.getSource();
            if (source instanceof JButton) {
                JButton jb = (JButton) source;
                if ((jb.getText().equals("MW"))) //MTO
                {
                    memory = Double.parseDouble(str.getText());
                }
                if ((jb.getText().equals("MR"))) //MFROM
                {
                    str.setText(memory + "");
                }
            }
        }
    }

    public class SqrtActList implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            isMultiEg=false;
            str.setText(sqroot(Double.parseDouble(str.getText())) + "");
        }
    }


    public class PlusActList implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(isMultiEg) {
                tc = tempCom.plus;
                isMultiEg=false;
            }
            else {
                tempNum = Double.parseDouble(str.getText());
                chk(tc);
                tc = tempCom.plus;
                //str.setText(result+"");
                beg = true;
            }
        }
    }

    public class DivideActList implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(isMultiEg) {
                tc = tempCom.divide;
                isMultiEg=false;
            }
            else {
                tempNum = Double.parseDouble(str.getText());
                chk(tc);
                tc = tempCom.divide;
                //str.setText(result+"");
                beg = true;
            }
        }
    }

    public class MultipleActList implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(isMultiEg) {
                tc = tempCom.multiple;
                isMultiEg=false;
            }
            else {
                tempNum = Double.parseDouble(str.getText());
                chk(tc);
                tc = tempCom.multiple;
                //str.setText(result+"");
                beg = true;
            }
        }
    }

    public class MinusActList implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(isMultiEg) {
                tc = tempCom.minus;
                isMultiEg=false;
            }
            else {
                tempNum = Double.parseDouble(str.getText());
                chk(tc);
                tc = tempCom.minus;
                //str.setText(result+"");
                beg = true;
            }
        }
    }

    public void chk(tempCom tc) {
        double res = 0;

        if (tc.equals(tempCom.enter)) {
            res = Double.parseDouble(str.getText());
            result = res;
        }

        if(!(isMultiEg)) {
            tempNum=Double.parseDouble(str.getText());
        }

        if (tc.equals(tempCom.plus)) {
            res = plus(tempNum);
        }
        if (tc.equals(tempCom.minus)) {
            res = minus(tempNum);

        }
        if (tc.equals(tempCom.divide)) {
            res = divide(tempNum);

        }
        if (tc.equals(tempCom.multiple)) {
            res = multiple(tempNum);

        }


        str.setText(result + "");
        str2.setText(result + ""); // for checking!
    }
}