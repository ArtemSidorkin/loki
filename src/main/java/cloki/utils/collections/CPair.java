package cloki.utils.collections;

import java.util.Objects;

public class CPair<T1, T2>
{
	private T1 _1;
	private T2 _2;

	public CPair() {}

	public CPair(T1 _1, T2 _2)
	{
		this._1 = _1;
		this._2 = _2;
	}

	public T1 get_1()
	{
		return _1;
	}

	public void set_1(T1 _1)
	{
		this._1 = _1;
	}

	public T2 get_2()
	{
		return _2;
	}

	public void set_2(T2 _2)
	{
		this._2 = _2;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(_1, _2);
	}

	@Override
	public boolean equals(Object object)
	{
		return
		(
			object != null &&
			object instanceof CPair &&
			((CPair)object)._1 != null &&
			((CPair)object)._1 .equals(_1) &&
			((CPair)object)._2 != null &&
			((CPair)object)._2 .equals(_2)
		);
	}

	@Override
	public String toString()
	{
		return String.format("(%s, %s)", _1, _2);
	}
}
