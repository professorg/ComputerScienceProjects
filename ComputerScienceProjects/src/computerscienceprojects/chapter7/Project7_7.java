/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscienceprojects.chapter7;

/**
 *
 * @author gvandomelen19
 */
public class Project7_7 {
    
    public static void main(String[] args) {
        
        System.out.println("l(ft)\tw(ft)\ta(ft^2)\tp(ft)");
        
        for (int l = 1; l <= 10; l++) {
            
            for (int w = 1; w <= 10; w++) {
                
                System.out.println(l + "\t" + w + "\t" + l*w + "\t" + (2*l + 2*w));
            }
        }
    }
    /*
        l (ft)	w (ft)	a (ft^2)p (ft)
        1	1	1	4
        1	2	2	6
        1	3	3	8
        1	4	4	10
        1	5	5	12
        1	6	6	14
        1	7	7	16
        1	8	8	18
        1	9	9	20
        1	10	10	22
        2	1	2	6
        2	2	4	8
        2	3	6	10
        2	4	8	12
        2	5	10	14
        2	6	12	16
        2	7	14	18
        2	8	16	20
        2	9	18	22
        2	10	20	24
        3	1	3	8
        3	2	6	10
        3	3	9	12
        3	4	12	14
        3	5	15	16
        3	6	18	18
        3	7	21	20
        3	8	24	22
        3	9	27	24
        3	10	30	26
        4	1	4	10
        4	2	8	12
        4	3	12	14
        4	4	16	16
        4	5	20	18
        4	6	24	20
        4	7	28	22
        4	8	32	24
        4	9	36	26
        4	10	40	28
        5	1	5	12
        5	2	10	14
        5	3	15	16
        5	4	20	18
        5	5	25	20
        5	6	30	22
        5	7	35	24
        5	8	40	26
        5	9	45	28
        5	10	50	30
        6	1	6	14
        6	2	12	16
        6	3	18	18
        6	4	24	20
        6	5	30	22
        6	6	36	24
        6	7	42	26
        6	8	48	28
        6	9	54	30
        6	10	60	32
        7	1	7	16
        7	2	14	18
        7	3	21	20
        7	4	28	22
        7	5	35	24
        7	6	42	26
        7	7	49	28
        7	8	56	30
        7	9	63	32
        7	10	70	34
        8	1	8	18
        8	2	16	20
        8	3	24	22
        8	4	32	24
        8	5	40	26
        8	6	48	28
        8	7	56	30
        8	8	64	32
        8	9	72	34
        8	10	80	36
        9	1	9	20
        9	2	18	22
        9	3	27	24
        9	4	36	26
        9	5	45	28
        9	6	54	30
        9	7	63	32
        9	8	72	34
        9	9	81	36
        9	10	90	38
        10	1	10	22
        10	2	20	24
        10	3	30	26
        10	4	40	28
        10	5	50	30
        10	6	60	32
        10	7	70	34
        10	8	80	36
        10	9	90	38
        10	10	100	40
    */
}
