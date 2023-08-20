import unittest
from calc.funs import add


class TestCalc(unittest.TestCase):
    def test_should_add_two_numbers(self):
        self.assertEqual(add(1, 2), 3)
        self.assertNotEqual(add(1, 2), 12)
