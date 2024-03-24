package kr.co.sist.view.util;

import javax.swing.*;
import java.awt.*;

/**
 * Desc : view 작성시 공통적으로 사용될 method 모음<br>
 * 작성자 : 고한별
 * 작성일 : 2024.03.24
 */
public class JFrameComponent extends JFrame {
    /**
     * Desc : textField를 생성
     *
     * @param container 컴포넌트 추가...
     * @param text      textField 내부에 기록될 초기값
     * @param x         x 좌표
     * @param y         y 좌표
     * @param width     가로 픽셀
     * @param height    세로 픽셀
     * @return 생성된 textField
     */
    public static JTextField createTextField(Container container, String text, int x, int y, int width, int height) {
        JTextField textField = new JTextField();

        textField.setText(text);
        textField.setBounds(x, y, width, height);
        container.add(textField);

        return textField;
    }

    public static JTextField createTextField(Container container, String text, int x, int y, int width, int height, boolean edit) {
        JTextField textField = new JTextField();

        textField.setText(text);
        textField.setBounds(x, y, width, height);
        textField.setEditable(edit);
        container.add(textField);

        return textField;
    }

    /**
     * Desc : 버튼을 생성하는 기능
     *
     * @param container add 하려고...
     * @param text      버튼에 표시될 내용
     * @param x         버튼의 x 좌표
     * @param y         버튼의 y 좌표
     * @param width     버튼의 가로 픽셀
     * @param height    버튼의 세로 픽셀
     * @return 생성된 JButton
     */
    public static JButton createButton(Container container, String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);

        button.setBounds(x, y, width, height);
        container.add(button);

        return button;
    }

    /**
     * Desc : 라벨을 생성하는 기능
     *
     * @param container add 하려고...
     * @param text      라벨에 표시될 내용
     * @param x         라벨의 x 좌표
     * @param y         라벨의 y 좌표
     * @param width     라벨의 가로 픽셀
     * @param height    라벨의 세로 픽셀
     * @return 생성된 JLabel
     */
    public static JLabel createLabel(Container container, String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);

        label.setBounds(x, y, width, height);
        container.add(label);

        return label;
    }

    /**
     * Desc : 라벨을 생성하는 기능
     *
     * @param container 컨테이너
     * @param jTextArea jsp에 붙일 jta
     * @param x         jsp의 x 좌표
     * @param y         jsp의 y 좌표
     * @param width     jsp의 가로 픽셀
     * @param height    jsp의 세로 픽셀
     * @return 생성된 JScrollPane
     */
    public static JScrollPane createPane(Container container, JTextArea jTextArea, int x, int y, int width, int height) {
        jTextArea = new JTextArea();

        JScrollPane jScrollPane = new JScrollPane(jTextArea);

        jScrollPane.setBounds(x, y, width, height);
        container.add(jScrollPane);

        return jScrollPane;
    }

    public static JScrollPane createPane(Container container, JTextArea jTextArea, int x, int y, int width, int height, boolean edit, boolean line, boolean style) {
        jTextArea = new JTextArea();

        JScrollPane jScrollPane = new JScrollPane(jTextArea);

        jScrollPane.setBounds(x, y, width, height);
        container.add(jScrollPane);

        jTextArea.setEditable(edit);
        jTextArea.setLineWrap(line);
        jTextArea.setWrapStyleWord(style);

        return jScrollPane;
    }

}
