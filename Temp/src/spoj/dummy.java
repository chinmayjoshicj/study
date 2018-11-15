
package spoj;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class dummy extends JFrame {
    public dummy() throws HeadlessException {
        initializeUI();
    }

    private void initializeUI() {
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Address Book");
        String[] names = new String[] {"Alice", "Bob", "Carol", "Mallory"};
        for (String name : names) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(name);
            root.add(node);
        }

        final JTree tree = new JTree(root);
        JScrollPane pane = new JScrollPane(tree);
        pane.setPreferredSize(new Dimension(400, 400));

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

                TreePath[] paths = tree.getSelectionPaths();
                if (paths != null) {
                    for (TreePath path : paths) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) 
                            path.getLastPathComponent();
                        if (node.getParent() != null) {
                            model.removeNodeFromParent(node);
                        }
                    }
                }
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(tree, BorderLayout.CENTER);
        getContentPane().add(removeButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new dummy().setVisible(true);
            }
        });
    }
}